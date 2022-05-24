
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.JDBCException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperJdbcException implements ExceptionMapper<JDBCException>{

    @Override
    public Response toResponse(JDBCException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(447);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
