
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.PessimisticLockException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperPessimisticLockException implements ExceptionMapper<PessimisticLockException>{

    @Override
    public Response toResponse(PessimisticLockException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(457);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
