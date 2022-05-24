
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.jboss.resteasy.spi.UnhandledException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperUnhandledException implements ExceptionMapper<UnhandledException> {

    @Override
    public Response toResponse(UnhandledException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(510);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
