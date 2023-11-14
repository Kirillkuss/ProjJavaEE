package com.itrail.test.rest;

import com.itrail.test.domain.TotalFeatures;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "TotalFeatures", tags = {"TotalFeatures"}, produces = "application/json")
public interface FeaturesRecource {
    
    @POST
    @Path( "/addMap")
    @ApiOperation(value = "Получение геоданных")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List Features",response = TotalFeatures.class)})
    public TotalFeatures addTotalFeatures( TotalFeatures request ) throws Exception;
    
    
}
