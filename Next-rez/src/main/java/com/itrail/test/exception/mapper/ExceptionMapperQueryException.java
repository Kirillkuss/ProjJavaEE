
package com.itrail.test.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.QueryException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperQueryException implements ExceptionMapper<QueryException>{

    @Override
    public Response toResponse(QueryException e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
