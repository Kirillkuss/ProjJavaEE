package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import java.time.format.DateTimeParseException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperDateTimeParseException implements ExceptionMapper<DateTimeParseException>{

    @Override
    public Response toResponse(DateTimeParseException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(577);
        bs.setMessage(null == e.getMessage() ? "DateTimeParseException" : e.getMessage());
        return Response.ok().entity(bs).build();
    }  
}
