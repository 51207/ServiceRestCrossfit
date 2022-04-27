/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.isib.servicerestcrossfit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


/**
 *
 * @author aliou
 */
@Data
public class apiListTest implements Serializable{
    private List<NotationClientInscrit>list;

  
    
    public apiListTest(){
        list = new ArrayList<>();
       
    }
    
    public void setList2(NotationClientInscrit notationclient){
    
        this.list.add(notationclient);
    }
    
}
