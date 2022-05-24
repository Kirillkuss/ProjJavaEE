package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.exception.LockAcquisitionException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperLockAcquisitionException implements ExceptionMapper<LockAcquisitionException>{

    @Override
    public Response toResponse(LockAcquisitionException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(456);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
