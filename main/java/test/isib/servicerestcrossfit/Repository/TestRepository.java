/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package test.isib.servicerestcrossfit.Repository;



import test.isib.servicerestcrossfit.Tables.Test;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author aliou
 */
public interface TestRepository  extends CrudRepository<Test, String> {
    
  
   
       @Query(value="select t from Test t where t.testPK.tDates=:dates")
       public List<Test> getAllTestByDates(@Param("dates") String  date);
}
