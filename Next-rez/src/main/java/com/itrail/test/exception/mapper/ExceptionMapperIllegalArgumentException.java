
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperIllegalArgumentException implements ExceptionMapper<IllegalArgumentException>{

    @Override
    public Response toResponse(IllegalArgumentException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(430);
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
}
