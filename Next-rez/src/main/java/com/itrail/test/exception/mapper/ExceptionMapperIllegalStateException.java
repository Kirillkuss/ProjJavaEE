
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperIllegalStateException implements ExceptionMapper<IllegalStateException>{

    @Override
    public Response toResponse(IllegalStateException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(570);
        bs.setMessage(null == e.getMessage() ? "IllegalStateException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
