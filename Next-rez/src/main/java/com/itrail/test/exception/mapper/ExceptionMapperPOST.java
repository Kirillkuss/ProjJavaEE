
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
public class ExceptionMapperPOST implements ExceptionMapper<NullPointerException> {

    @Override
    public Response toResponse(NullPointerException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(0);
        bs.setMessage(null == e.getMessage() ? "Not Data found" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
