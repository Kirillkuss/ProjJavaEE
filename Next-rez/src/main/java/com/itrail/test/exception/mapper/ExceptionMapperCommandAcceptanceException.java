/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itrail.test.exception.mapper;

import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;

/**
 *
 * @author barysevich_k
 */
public class ExceptionMapperCommandAcceptanceException implements ExceptionMapper<CommandAcceptanceException>{

    @Override
    public Response toResponse(CommandAcceptanceException e) {
        BaseResponse bs = new BaseResponse();
        bs.setCode(545);
        bs.setMessage(null == e.getMessage() ? "Invalid request SQL" : e.getMessage());
        return Response.ok().entity(bs).build(); 
    }
    
    
}
