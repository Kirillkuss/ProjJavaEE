package com.itrail.test.exception.mapper;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperJsonMappingException implements ExceptionMapper<JsonMappingException> {

    @Override
    public Response toResponse(JsonMappingException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(456);
        bs.setMessage(null == e.getMessage() ? "JsonMappingException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
