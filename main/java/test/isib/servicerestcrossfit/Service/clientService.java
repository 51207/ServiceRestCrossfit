/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit.Service;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import test.isib.servicerestcrossfit.ApiClient;
import test.isib.servicerestcrossfit.Repository.ClientsRepository;
import test.isib.servicerestcrossfit.Tables.Clients;

/**
 *
 * @author aliou
 */
@Service
public class clientService {
    private final ClientsRepository clientRepository;

    @Autowired
    public clientService(ClientsRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PersistenceContext
    private EntityManager em;
    
    
      //Create or update
    public void CreateClients(Clients client) {

        clientRepository.save(client);

    }
      //recuperer le client qui a comme username:String username
      public  Clients ForgotPassword(@Param("username") String username){
      
       try{
        Clients c = clientRepository.ForgotPassword(username);
        
        
        return c;
       }catch(NullPointerException e){
       
       return null;
       }
      }
      
      public void deleteclient(Clients client){
      
          clientRepository.delete(client);
      }
     
}
