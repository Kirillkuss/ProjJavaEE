
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
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
/**
 *
 * @author barysevich_k
 */
@Path("animalEM")
public class AnimalTwoAPI implements AnimalResourceTwo{
    
    private static final Logger LOGGER = LogManager.getLogger(AnimalTwoAPI.class);
    private static final Marker ANIMALS= MarkerManager.getMarker("ANI");
    
    @EJB private AnimalServiceTwo service;

    @Override
      public BaseResponse getAnimalByList() {          
        BaseResponse bs = new BaseResponse(200, "success");     
        List l = service.getAnimalByList();  
        IntStream.range(1, 20000).parallel().forEach( r -> {
            l.add( service.getAnimalByList() );
        });
        bs.setData(l);
        LOGGER.info(ANIMALS,"method getAnimalByList" );
        return bs;
    }

    @Override
    public BaseResponse getAnimalById(Integer idAnimal) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAnimalById(idAnimal));
                LOGGER.error(ANIMALS,"method getAnimalById");
        return bs;
    }

    @Override
    public BaseResponse getWithoutOwner() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.withoutOwner());
                LOGGER.info(ANIMALS,"method getWithoutOwner");
        return bs;
    }   
}
