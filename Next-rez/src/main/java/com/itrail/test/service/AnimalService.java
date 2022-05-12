
package com.itrail.test.service;

import com.itrail.test.domain.Animal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
/**
 *
 * @author barysevich_k
 */
@Stateless
public class AnimalService {
    private int number =32;

    public int getNumber() {
        return number;
    }
   List<Animal> us4 = new LinkedList<>(Arrays.asList(new Animal(1,"cat",new BigDecimal("100.23"),2),
                                                     new Animal(5,"dog", new BigDecimal("50.21"),1),
                                                     new Animal(20,"bird", new BigDecimal("150.25677"),2),
                                                     new Animal(24,"turtle", new BigDecimal("200.4686"),2),
                                                     new Animal(40,"snake", new BigDecimal("300.8789"),3)));
   
     public List<Animal> getAnimal(){
           return us4;
    } 
     
     public Animal getAnimalId(Integer idAnimal){
         return us4.stream().filter(s->Objects.equals(s.getIdAnimal(), idAnimal)).findFirst().orElse(null);
         
     }
     
    public List<Animal> withoutOwner(){
        List<Animal> us1 = us4.stream()
                              //.filter(s->null == s.getOwner())
                              .collect(Collectors.toList());
        return us1;
    }
  
    public BigDecimal sumCoat(){
        return us4.stream()
                  .map(Animal::getCoat)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .setScale(2,RoundingMode.HALF_EVEN);
    }

    public int modifyNumber(int newNumber){
        this.number = newNumber;
        return number;
    }
    
//    public void addUserForAnimal(){
//            Map<Integer,List<Animal>> animalsWithUser = us4.stream()
//                                                .filter(s->null ==s.getOwner())
//                                                .collect(Collectors.groupingBy(Animal::getIdAnimal));
//        //List<Animal> animalsWithUser = us4.stream().filter(s-> null ==s.getOwner()).collect(()-> new List<Animal>(),(list, item) ->list.add(item)),(lis1,list2) -> list1.addAll(list2);
//    System.out.println(animalsWithUser);    
//}   
}
    
    
    
    
    

