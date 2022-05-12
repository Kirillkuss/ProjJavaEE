
package com.itrail.test.rest.impl;



import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.AnimalResource;
import com.itrail.test.service.AnimalService;
import com.itrail.test.service.CalcService;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("animal")
public class AnimalAPI implements AnimalResource{
    
    @EJB private AnimalService service2;
    @EJB private CalcService service;
   
    @Override
    public BaseResponse getAnimal() throws ItException { 
        BaseResponse bs = new BaseResponse(200,"success");
        //try{
                List<Animal> res = service2.getAnimal();
                bs.setData(res);
                service.getMyAnimal();
//        } catch(ItException ex){
//                return new BaseResponse( ex.getPri(), ex.getMessage() );
//        }
        return bs;
    }

    @Override
    public BaseResponse getAnimalID(Integer idAnimal) throws ItException {
        BaseResponse bs = new BaseResponse(200, "success");
            bs.setData(service2.getAnimalId(idAnimal));
       return bs;
        
    }
    @Override
    public BaseResponse sumCoatAni() throws ItException{ 
        BaseResponse bs = new BaseResponse(200,"success");
            BigDecimal res = service2.sumCoat();   
            bs.setData(res);
            service.getAnimalCoat();
        return bs;
    } 

    @Override
    public BaseResponse withoutOwnerList() throws ItException{
        BaseResponse bs = new BaseResponse(200, "success");
            List<Animal> res = service2.withoutOwner();
            bs.setData(res);
            service.getWithoutOwner();
        return bs;
    }
    
    @Override
     public BaseResponse getMyCalc() throws ItException{
         BaseResponse bs = new BaseResponse(200, "success");
             int rez = service2.getNumber();
             bs.setData(rez);
             service.getMyCalc();
         return bs;
     }
     
    @Override
    public BaseResponse modifyNumber(int number) {
        BaseResponse bs = new BaseResponse(200,"success");
        try{   
            int rez = service2.modifyNumber(number);
            bs.setData(rez);
        } catch (Exception ex){
            return new BaseResponse(400,"not found");
        }
       return bs;
    }

 
    
}
     
     
     
     
     
    
