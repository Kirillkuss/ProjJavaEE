package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperPersistenceException implements ExceptionMapper<PersistenceException> {

    @Override
    public Response toResponse(PersistenceException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(446);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
