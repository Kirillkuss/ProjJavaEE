package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.QueryTimeoutException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperQueryTimeoutException implements ExceptionMapper<QueryTimeoutException>{

    @Override
    public Response toResponse(QueryTimeoutException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(578);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
