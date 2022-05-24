
package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.RollbackException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperRollbackException implements ExceptionMapper<RollbackException>{

    @Override
    public Response toResponse(RollbackException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(579);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
