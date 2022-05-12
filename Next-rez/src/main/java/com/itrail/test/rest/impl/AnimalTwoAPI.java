
package com.itrail.test.rest.impl;


import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.ServerTime;
import com.itrail.test.rest.AnimalResourceTwo;
import com.itrail.test.service.AnimalServiceTwo;
import com.itrail.test.service.LogService;
import java.util.List;
import java.util.stream.IntStream;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import org.apache.logging.log4j.Level;
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
    @EJB private LogService service2;

    @Override
      public BaseResponse getAnimalByList() {
          
        BaseResponse bs = new BaseResponse(200, "success");
        
        List l = service.getAnimalByList();
        
        IntStream.range(1, 20000).parallel().forEach( r -> {
            l.add( service.getAnimalByList() );
        });
        bs.setData(l);
        LOGGER.info("method getAnimalByList" );
        service2.createLog(new LogView(null, new ServerTime().getTime(),"method getAnimalByList"));
        return bs;
    }

    @Override
    public BaseResponse getAnimalById(Integer idAnimal) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAnimalById(idAnimal));
                LOGGER.info("method getAnimalById");
                service2.createLog(new LogView(null, new ServerTime().getTime(),LOGGER.toString()));
        return bs;
    }

    @Override
    public BaseResponse getWithoutOwner() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.withoutOwner());
                LOGGER.info("method getWithoutOwner");
                service2.createLog(new LogView(null, new ServerTime().getTime(),LOGGER.toString()));
        return bs;
    }   
}
