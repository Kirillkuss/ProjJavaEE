package com.itrail.test.exception.mapper;


import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ItExceptionMapper implements ExceptionMapper<ItException>{

    @Override
    public Response toResponse(ItException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(e.getPri() == 0 ? 999 : e.getPri());
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.status( e.getPri() == 0 ? 200 : e.getPri() ).entity(bs).build();
    }


    
}
