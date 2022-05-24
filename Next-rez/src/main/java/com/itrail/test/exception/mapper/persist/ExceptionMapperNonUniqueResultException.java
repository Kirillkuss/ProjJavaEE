
package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.NonUniqueResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperNonUniqueResultException implements ExceptionMapper<NonUniqueResultException>{

    @Override
    public Response toResponse(NonUniqueResultException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(574);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
