package com.itrail.test.rest;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.exception.mapper.ItException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "LOGGER", produces = "application/json")
public interface LogResource {
  
    @GET
    @ApiOperation(value = "LOGGER")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "LOGGER", response = LogView.class)})
    public BaseResponse getLog();
    
    
    @POST
    @ApiOperation(value = "Поиск логгов")
    @ApiResponses(value ={
        @ApiResponse(code = 200, message ="Поиск логгов", response = LogView.class)})
    public LogView getListFilterLog(@ApiParam(required = true) FilterLog filterLog) throws ItException ;
    
    
}

