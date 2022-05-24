
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperJDBCConnectionException implements ExceptionMapper<JDBCConnectionException> {

    @Override
    public Response toResponse(JDBCConnectionException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(516);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
