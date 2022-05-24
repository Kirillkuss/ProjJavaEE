
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperRuntimeException implements ExceptionMapper<RuntimeException>{

    @Override
    public Response toResponse(RuntimeException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(455);
        bs.setMessage(null == e.getMessage() ? "RuntimeException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
