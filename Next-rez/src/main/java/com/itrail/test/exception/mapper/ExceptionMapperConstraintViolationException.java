
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperConstraintViolationException implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
 
        BaseResponse bs = new BaseResponse();
        bs.setCode(602);
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
    
}
