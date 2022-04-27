/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package test.isib.servicerestcrossfit.Repository;


import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.isib.servicerestcrossfit.Tables.Clients;

/**
 *
 * @author aliou
 */
@Repository
public interface ClientsRepository extends CrudRepository<Clients, Integer> {

    @Query(value="Select c from Clients c where c.username=:username")
  public Clients ForgotPassword(@Param("username") String username);
  
 
}
