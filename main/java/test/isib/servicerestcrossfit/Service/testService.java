/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import test.isib.servicerestcrossfit.Repository.TestRepository;
import test.isib.servicerestcrossfit.Tables.Test;

/**
 *
 * @author aliou
 */
@Service
public class testService {

    private final TestRepository testRepository;

    //constructeur
    @Autowired
    public testService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    //context de persistence
    @PersistenceContext
    private EntityManager em;

    
    public List<Test> getAllTestByDates(String  date){
    
        try{
       List<Test> list = testRepository.getAllTestByDates(date);
       if( list.isEmpty()){
           return null;
       }else{
            return list;
       }
        }catch(NullPointerException e ){
            return null;
        }
    
    }
    
    
  
}
