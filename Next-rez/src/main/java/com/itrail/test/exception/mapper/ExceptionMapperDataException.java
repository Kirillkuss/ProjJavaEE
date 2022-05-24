
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.exception.DataException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperDataException implements ExceptionMapper<DataException> {

    @Override
    public Response toResponse(DataException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(571);
        bs.setMessage(null == e.getMessage() ? "DataException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}
