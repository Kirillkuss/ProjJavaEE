
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.hibernate.HibernateException;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperHibernateException implements ExceptionMapper<HibernateException> {

    @Override
    public Response toResponse(HibernateException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(455);
        bs.setMessage(null == e.getMessage() ? "HibernateException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
    
}
