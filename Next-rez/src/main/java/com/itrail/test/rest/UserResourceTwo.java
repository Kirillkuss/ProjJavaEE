package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Api(value = "UserTwo", tags = {"User"})
public interface UserResourceTwo {

    @GET
    @ApiOperation(value = "Поиск пользователей")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " List Users"),
        @ApiResponse(code=404, message="Not found",response = BaseResponse.class)
    })
    public BaseResponse getAllUsers();

    @GET
    @Path("/{idUser}")
    @ApiOperation(value = "Поиск пользовтеля по ИД")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Пользователь найден"),
        @ApiResponse(code = 500, message = "пользователь не найден",response = BaseResponse.class)
    })
    public BaseResponse getUserByID(@ApiParam(required = true) @PathParam("idUser") Integer idUser);

    @PUT
    @Path("/create")
    @ApiOperation(value = "Добавление пользователя")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Пользователь добавлен",response = User.class),
        @ApiResponse(code = 500, message = " Пользователь не добавлен",response = BaseResponse.class)})
    public BaseResponse createUser(@ApiParam(required = true) User user);

    @POST
    @Path("/{idUser}/{name}")
    @ApiOperation(value = "Изменения имени пользователя")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Rename User"),
        @ApiResponse(code = 500, message = "Not Rename User",response = BaseResponse.class)})
    public BaseResponse updateUser(@ApiParam(required = true) @PathParam("idUser") Integer idUser, @ApiParam(required = true) @PathParam("name") String name);

    @DELETE
    @Path("/{idUser}")
    @ApiOperation(value = "Удаление пользователя")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Пользователь удален"),
        @ApiResponse(code = 500, message = "Пользователь не удален",response = BaseResponse.class)})
    public BaseResponse deleteUserUM(@ApiParam(required = true) @PathParam("idUser") Integer idUser);

}
