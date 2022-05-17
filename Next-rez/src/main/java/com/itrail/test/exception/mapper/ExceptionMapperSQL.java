package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import java.sql.SQLException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperSQL implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(707);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
