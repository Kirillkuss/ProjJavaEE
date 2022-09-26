package com.itrail.test.rest;

import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRequest;
import com.itrail.test.domain.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
@Api(value = "BuyAnimals", tags = {"Buy"})
public interface BuyResource {
    
    @GET
    @ApiOperation(value = "Поиск заказов с 00:00 по настоящее время сегодняшего дня")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Список заказов",        response = Order.class),
        @ApiResponse(code = 500, message = "Списка заказов нет",    response = BaseResponse.class)})
    public BaseResponse getListOrder();

    @POST
    @Path("/{animal}/{user}")
    @ApiOperation(value = "Покупка питомца", authorizations = @Authorization(value = "token"))
    @ApiResponses(value = {
        @ApiResponse(code = 50, message = "Недостаточно денег"),
        @ApiResponse(code = 51, message = "Нет животных в магазине"),
        @ApiResponse(code = 200, message = "Покупка завершена", response = Order.class),
        @ApiResponse(code = 401, message = "Значение ключа не может быть равным нулю или пустым, повторите попытку!"),
        @ApiResponse(code = 403, message = "Неверный ключ, повторите попытку!")})
    public BaseResponse getBuyAnimal(
        @ApiParam(required = false, value = "Ид питомца")           @PathParam("animal") Integer idAnimal,
        @ApiParam(required = false, value = "Ид пользователя")      @PathParam("user") Integer idUser,
        @ApiParam(value = "ключ", example = " ")                   @HeaderParam("X-API-KEY") String key
    ) throws ItException;

    @POST
    @Path("/order")
    @ApiOperation(value = "Поиск 1-го заказа")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Заказ найден",         response = Order.class),
        @ApiResponse(code = 500, message = "Заказ не найден",       response = BaseResponse.class)})
    public Order getOrder(@ApiParam(required = true) OrderRequest req) throws ItException;

    @POST
    @Path("/orders")
    @ApiOperation(value = "Поиск всех заказов")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Заказы найдены",       response = OrderResponse.class),
        @ApiResponse(code = 500, message = " Заказ не найден",      response = BaseResponse.class)})
    public OrderResponse getOrders(@ApiParam(required = true) OrderRequest req) throws ItException;

}
