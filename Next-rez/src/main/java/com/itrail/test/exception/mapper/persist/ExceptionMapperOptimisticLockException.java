
package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperOptimisticLockException implements ExceptionMapper<OptimisticLockException>{

    @Override
    public Response toResponse(OptimisticLockException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(576);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
