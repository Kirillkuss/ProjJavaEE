package com.itrail.test.rest;

import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author barysevich_k
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Animals", tags = {"Animal"},authorizations = {@Authorization(value="sampleoauth", scopes = {})}, produces = "application/json")
public interface AnimalResourceTwo {

    @GET
    @ApiOperation(value = "Список животных")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " List Animal",response = Animal.class)})
    public BaseResponse getAnimalByList();

    @GET
    @Path("/{idAnimal}")
    @ApiOperation(value = "Поиск животного по ИД")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " One Animal",response = Animal.class)})
    public BaseResponse getAnimalById(@ApiParam(required = true) @PathParam("idAnimal") Integer idAnimal);

    @GET
    @Path("/owner/no")
    @ApiOperation(value = "Животные без хозяина")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " List Animal",response = Animal.class)})
    public BaseResponse getWithoutOwner();
    
}
