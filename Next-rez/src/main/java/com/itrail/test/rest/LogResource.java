package com.itrail.test.rest;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.app.model.LogResponse;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.Level;
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
        @ApiResponse(code = 200, message = "LOGGER")})
    public BaseResponse getLog();
    
    @POST
    @Path("/requestJPQL")
    @ApiOperation(value = "Поиск логгов JPQL")
    @ApiResponses(value ={
        @ApiResponse(code = 200, message ="Поиск логгов JPQL",response = LogView.class)})
    public LogResponse getListFilterLogJPQL(@ApiParam(required = false)FilterLog filterLog) throws Exception;
    
    @POST
    @Path("/requestSQL")
    @ApiOperation(value = "Поиск логгов SQL")
    @ApiResponses(value ={
        @ApiResponse(code = 200, message ="Поиск логгов SQL",response = LogView.class)})
    public LogResponse getListFilterLogSQL(@ApiParam(required = false)FilterLog filterLog) throws Exception;
    
    @POST
    @Path("/requestJPA")
    @ApiOperation(value = "Поиск логгов JPA")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Поиск логгов JPA", response = LogView.class)})
    public BaseResponse getListLogJPA(@ApiParam(required = false) FilterLog filteLog) throws Exception;
    
    @POST
    @Path("/Subquery")
    @ApiOperation(value = "Поиск логгов Subquery")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Поиск логгов Subquery", response = LogView.class)})
    public BaseResponse getListLogSubQuery(@ApiParam(required = false) FilterLog filterLog);
    
    @POST
    @Path("/example/{id}/{level}")
    @ApiOperation(value = "Example")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success")})
    public BaseResponse getExample(@ApiParam(required = false,example = "1") @PathParam("id") Long id,@ApiParam(required = false,example ="INFO") @PathParam("level") Level level);
      
    @POST
    @Path("UserLog")
    public BaseResponse setLog( LogData data );
    
}

