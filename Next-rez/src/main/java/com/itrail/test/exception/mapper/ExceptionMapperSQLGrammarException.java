
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.exception.SQLGrammarException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperSQLGrammarException implements ExceptionMapper<SQLGrammarException> {

    @Override
    public Response toResponse(SQLGrammarException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(691);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
