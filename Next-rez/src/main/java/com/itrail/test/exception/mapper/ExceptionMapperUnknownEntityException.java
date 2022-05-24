
package com.itrail.test.exception.mapper;

import javax.lang.model.UnknownEntityException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperUnknownEntityException implements ExceptionMapper<UnknownEntityException> {

    @Override
    public Response toResponse(UnknownEntityException e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
