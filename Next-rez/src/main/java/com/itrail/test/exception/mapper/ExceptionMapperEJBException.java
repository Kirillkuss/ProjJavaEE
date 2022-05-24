
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperEJBException implements ExceptionMapper<EJBException>{

    @Override
    public Response toResponse(EJBException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(580);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
