
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.LogResource;
import com.itrail.test.service.LogService;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author barysevich_k
 */
@Path("log")
public class LogAPI implements LogResource{
    
    @EJB LogService service;
    @Override
    public BaseResponse getLog() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAllLog());
       return bs;
    }
    
    
}
