
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author barysevich_k
 */
public class ExceptinMapperGenericJDBCException implements ExceptionMapper<GenericJDBCException>{

    @Override
    public Response toResponse(GenericJDBCException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(550);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
