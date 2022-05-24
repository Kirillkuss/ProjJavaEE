
package com.itrail.test.exception.mapper.persist;

import com.itrail.test.domain.BaseResponse;
import javax.persistence.TransactionRequiredException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperTransactionRequiredException implements ExceptionMapper<TransactionRequiredException> {

    @Override
    public Response toResponse(TransactionRequiredException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(569);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
}
