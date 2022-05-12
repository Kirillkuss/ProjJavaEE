
package com.itrail.test.rest;

import com.itrail.test.domain.ServerTime;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DateTimeResource {
    
    @GET
    public ServerTime dateServiceList();
   
}
