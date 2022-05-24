
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperPersistenceException implements ExceptionMapper<PersistenceException> {

    @Override
    public Response toResponse(PersistenceException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(444);
        bs.setMessage(null == e.getMessage() ? "PersistenceException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
