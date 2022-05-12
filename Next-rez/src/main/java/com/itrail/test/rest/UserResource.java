
package com.itrail.test.rest;

import com.itrail.test.domain.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.QueryParam;
/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource {
    
    @GET
    public List<User> getUserList();
   
    @GET
    @Path("/{idUser}")
    public User getUserById( @PathParam("idUser") Integer idUser);
  
    @POST
    @Path("/{idUser}/{name}")
    public User setUserName(@PathParam("idUser") Integer idUser, @PathParam("name") String name);
    
    @PUT
    @Path("/{idUser}")
    public User updateUser(@PathParam("idUser") Integer idUser, User user);
   
    @PUT
    @Path("/create")
    public void createUser(User user);
  
    @DELETE
    @Path("/{idUser}")
    public void deleteUser(@PathParam("idUser") Integer idUser);
    
}
