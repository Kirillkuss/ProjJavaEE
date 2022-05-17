
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.AnimalResourceTwo;
import com.itrail.test.service.AnimalServiceTwo;
import java.util.List;
import java.util.stream.IntStream;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author barysevich_k
 */
@Path("animalEM")
public class AnimalTwoAPI implements AnimalResourceTwo{
    
    private static final Logger LOGGER = LogManager.getLogger(AnimalTwoAPI.class);
    
    @EJB private AnimalServiceTwo service;

    @Override
      public BaseResponse getAnimalByList() {          
        BaseResponse bs = new BaseResponse(200, "success");     
        List l = service.getAnimalByList();  
        IntStream.range(1, 20000).parallel().forEach( r -> {
            l.add( service.getAnimalByList() );
        });
        bs.setData(l);
        LOGGER.info("method getAnimalByList" );
        return bs;
    }

    @Override
    public BaseResponse getAnimalById(Integer idAnimal) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAnimalById(idAnimal));
                LOGGER.error("method getAnimalById");
        return bs;
    }

    @Override
    public BaseResponse getWithoutOwner() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.withoutOwner());
                LOGGER.info("method getWithoutOwner");
        return bs;
    }   
}
