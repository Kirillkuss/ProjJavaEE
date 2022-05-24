
package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.LockTimeoutException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperLockTimeoutException implements ExceptionMapper<LockTimeoutException>{

    @Override
    public Response toResponse(LockTimeoutException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(573);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
