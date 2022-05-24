
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.QueryTimeoutException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperQueryTimeoutException implements ExceptionMapper<QueryTimeoutException>{

    @Override
    public Response toResponse(QueryTimeoutException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(458);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
