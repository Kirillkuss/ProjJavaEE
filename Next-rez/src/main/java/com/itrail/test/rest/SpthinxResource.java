package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api("sphinx")
@Path("sphinx")
public interface SpthinxResource {

    @POST
    @Path( "/eng/{record}")
    @ApiOperation(value = "Распознование речи англ")
    @ApiResponses(value = {         
        @ApiResponse( code = 200, message = "success",             response = BaseResponse.class ),
        @ApiResponse( code = 400, message = "Bad request",         response = BaseResponse.class ),
        @ApiResponse( code = 500, message = "System mallfunction", response = BaseResponse.class )
    })
    public BaseResponse getRecord( @PathParam( "record" ) @ApiParam( example = "D://Project/test/Next-rez/src/main/resources/terminator.wav")
        String record ) throws Exception;
    
    @POST
    @Path( "/ru/{record}")
    @ApiOperation(value = "Распознование речи рус")
    @ApiResponses(value = {         
        @ApiResponse( code = 200, message = "success",             response = BaseResponse.class ),
        @ApiResponse( code = 400, message = "Bad request",         response = BaseResponse.class ),
        @ApiResponse( code = 500, message = "System mallfunction", response = BaseResponse.class )
    })
    public BaseResponse getRuRecord( @PathParam( "record" ) @ApiParam( example = "D://Project/test/Next-rez/src/main/resources/decoder-test.wav")
        String record ) throws Exception;
    
}
    
