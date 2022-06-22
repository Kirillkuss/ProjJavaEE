
package com.itrail.test.service;

import com.itrail.test.domain.BaseResponse;

import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author barysevich_k
 */
@Stateless
public class CalcService {
    @EJB private AnimalService service;
  
    public BaseResponse getMyCalc() throws ItException {
           int number = service.getNumber();
           System.out.println("number = " + number);
        switch( number ) {
            case 0 : throw new ItException(100, " TestIllegalAccessException ");
            case 2 : throw new ItException(101, " TestIllegalArgumentException ");
            case 3 : throw new ItException(102, " TestException ");
            case 4 : throw new ItException(103, " TestException 2 ");
            case 5 : throw new ItException(104, " ItException - My Exception" );
        }  
        return new BaseResponse(0, "Success");     
    }
    
    public BaseResponse getMyAnimal() throws ItException{
        int number = service.getNumber();
        switch ( number ){
            case 0 : throw new ItException(90, "TestAnimalException 1");
            case 1 : throw new ItException(91, "TestAnimalException 2");
        }
        return new BaseResponse (0, "Success");
    }
    
    public BaseResponse getAnimalCoat() throws ItException{
        int number = service.getNumber();
        switch ( number ){
            case 0 : throw new ItException(80, "TestCoatException 1");
            case 1 : throw new ItException(81, "TestCoatException 2");
        }
        return new BaseResponse (0, "Success");
    }
    
    public BaseResponse getWithoutOwner() throws ItException{
        int number = service.getNumber();
        switch( number ){
            case 0: throw new ItException(70, "TestOwnerException 1");
            case 1: throw new ItException(71, "TestOwnerException 2");
        }
        return new BaseResponse (0, "Success");
    }
    
    @PersistenceContext
    private EntityManager em;
    
    public BaseResponse getBuyAnimal(Integer idAnimal, Integer idUser) throws ItException{
        Animal ani = em.find(Animal.class, idAnimal);
        User us = em.find(User.class, idUser);
        Integer a = ani.getCoat().compareTo(us.getWallet());
        switch(a){
            case -1 : throw new ItException(50," Not enough money to buy an animal "); 
        }
        return new BaseResponse (0, "Success");
    }
  
}
