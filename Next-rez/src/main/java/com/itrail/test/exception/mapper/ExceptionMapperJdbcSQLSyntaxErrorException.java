package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperJdbcSQLSyntaxErrorException implements ExceptionMapper<JdbcSQLSyntaxErrorException>{

    @Override
    public Response toResponse(JdbcSQLSyntaxErrorException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(611);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
