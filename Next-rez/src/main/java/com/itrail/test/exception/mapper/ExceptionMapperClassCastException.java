package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperClassCastException implements ExceptionMapper<ClassCastException> {

    @Override
    public Response toResponse(ClassCastException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(456);
        bs.setMessage(null == e.getMessage() ? "ClassCastException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
