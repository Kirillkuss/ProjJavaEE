
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import java.sql.SQLException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperSQLException implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(571);
        bs.setMessage(null == e.getMessage() ? "SQLException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
