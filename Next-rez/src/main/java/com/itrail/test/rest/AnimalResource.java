package com.itrail.test.rest;

import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.BaseResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author barysevich_k
 */
@Consumes({"application/json"})
@Produces({"application/json"})
public interface AnimalResource {

    @GET
    public BaseResponse getAnimal() throws ItException;

    @GET
    @Path("/{idAnimal}")
    public BaseResponse getAnimalID(@PathParam("idAnimal") Integer idAnimal) throws ItException;

    @GET
    @Path("/sum")
    public BaseResponse sumCoatAni() throws ItException;

    @GET
    @Path("/owner/no")
    public BaseResponse withoutOwnerList() throws ItException;

    @GET
    @Path("/calc/ex")
    public BaseResponse getMyCalc() throws ItException;

    @POST
    @Path("/update/{number}")
    public BaseResponse modifyNumber(@PathParam("number") int number);

}
