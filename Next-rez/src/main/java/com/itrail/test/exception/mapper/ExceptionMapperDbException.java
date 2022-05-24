
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.h2.message.DbException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperDbException implements ExceptionMapper<DbException>{

    @Override
    public Response toResponse(DbException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(582);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
