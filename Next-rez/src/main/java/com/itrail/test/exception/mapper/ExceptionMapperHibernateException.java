
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.HibernateException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperHibernateException implements ExceptionMapper<HibernateException>{

    @Override
    public Response toResponse(HibernateException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(515);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
