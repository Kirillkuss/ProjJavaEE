
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.h2.jdbc.JdbcSQLException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperJdbcSQLException implements ExceptionMapper<JdbcSQLException>{

    @Override
    public Response toResponse(JdbcSQLException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(612);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
