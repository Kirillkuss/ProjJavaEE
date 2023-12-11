package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.mqtt.SentMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author barysevich_k
 */
@Path("mqqt")
@Consumes({"application/json"})
@Produces({"application/json"})
@Api(value = "Mqqt", tags = {"Mqqt"})
public class MqqtController {
    
    @GET
    @Path("/{context}")
    @ApiOperation(value = "Отправить сообщение")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success" ,response = BaseResponse.class),
        @ApiResponse(code=404, message="Not found",response = BaseResponse.class)
    })
    public BaseResponse getPublish(@PathParam("context") String context ){
        SentMessage.getPublish( context );
        return new BaseResponse( 200, "success");
    }
    
}
