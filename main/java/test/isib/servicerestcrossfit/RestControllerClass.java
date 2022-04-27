/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.isib.servicerestcrossfit.Service.clientService;

import test.isib.servicerestcrossfit.Service.testService;
import test.isib.servicerestcrossfit.Tables.Clients;
import test.isib.servicerestcrossfit.Tables.Test;

/**
 *
 * @author aliou
 */

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/apijson")
public class RestControllerClass{
  
    @Autowired
    private testService testService;
 
   @Autowired
    private clientService clientservice;

    
    //on envoie vers 
    //ex:  http://localhost:8081/apijson/listTest/2019-04-11
     @GetMapping("/listTest/{date}")
    public apiListTest getListTest(@PathVariable String date) {
        //on initialise 
       
        apiListTest api= new apiListTest();

        // List<Test> 
        List<Test> t = testService.getAllTestByDates(date);
        //on encapsule daans cet objet  (listTest)
        for(var item : t ){
        
               NotationClientInscrit Notationclient = new NotationClientInscrit();
                    Notationclient.setDateCompetition(item.getTestPK().getTDates());
                    Notationclient.setIdclient(item.getClients().getNic() ); 
                    Notationclient.setIdNomEpreuve(item.getEpreuve().getNie());
                    Notationclient.setIdJury(item.getJury().getNIJury());
                    Notationclient.setIdclient(item.getTestPK().getTnic());
                    Notationclient.setNomEpreuve(item.getEpreuve().getNEpreuve());
                    Notationclient.setNom(item.getClients().getNom());
                    Notationclient.setPrenom(item.getClients().getPrenom());
                    Notationclient.setUsername(item.getClients().getUsername());
                    Notationclient.setNomjury(item.getJury().getNomJury());
                    Notationclient.setPremiereNote(item.getNote());
                    api.setList2(Notationclient);
        }
      
      
        return api;
    }
    
    
    
    
    
    
    //http://localhost:8080/apijson/PostClients
   
    
    public void createClient(ApiClient item){

                   Clients c = new Clients();
                  
                   c.setNic(item.getNic());
                   c.setNom(item.getNom());              
                   c.setPrenom(item.getPrenom());
                   c.setRue(item.getRue());
                   c.setNumero(item.getNumero());
                   c.setCp(item.getCp());
                   c.setCommune(item.getCommune());
                   c.setTel(item.getTel());
                   c.setUsername(item.getUsername());
                   c.setPasswordclient(item.getPassword());
                   
                   clientservice.CreateClients(c);
                  
    }
   
    //***postmapping : pour ajouter tous les clients
    @PostMapping("/PostClients")
    public void postclient(@RequestBody apiListClient body) {  // En principe le web service va stocker dans la BD
        // l'objet ....
        try{
        for (var item : body.getList()) {
               
                
                    Clients client = clientservice.ForgotPassword(item.getUsername());
                  if( client == null) {
                       //On crée tous les clients
                      createClient(item);
                  }
        }
        }catch(NullPointerException e){
        }

    }

    
    
    
    
    //*****Mis a jour des données du client*****
      //ex:  http://localhost:8081/apijson/UpdateClient/jack21
       @GetMapping("/UpdateClient/{username}")
    public Clients PutClient(@PathVariable String username) {

        Clients c = clientservice.ForgotPassword(username);
        return c;
    }
    
       @PutMapping("/UpdateClients")
    public void PutClients(@RequestBody ApiClient body) {
        
        
        
        Clients newclient = new Clients();
        newclient.setNic(body.getNic());
        newclient.setNom(body.getNom());
        newclient.setPrenom(body.getPrenom());
        newclient.setRue(body.getRue());
        newclient.setNumero(body.getNumero());
        newclient.setCp(body.getCp());
        newclient.setCommune(body.getCommune());
        newclient.setTel(body.getTel());
        newclient.setUsername(body.getUsername());
        newclient.setPasswordclient(body.getPassword());
        //update
        clientservice.CreateClients(newclient); 
     }
    
    
    
    //*****Mis a jour des données du client*****
      //ex:  http://localhost:8081/apijson/DeleteClient/jack21
       @DeleteMapping("/DeleteClient/{username}")
    public void DeleteClient(@PathVariable String PreviousUsername) {

        Clients c = clientservice.ForgotPassword(PreviousUsername);

        if (c != null) {

            clientservice.deleteclient(c);
        }
    }
}
