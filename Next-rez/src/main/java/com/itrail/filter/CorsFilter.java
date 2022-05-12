
package com.itrail.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */

@Provider
@PreMatching
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter{
        @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if ( isOptionsRequest( request ) )  request.abortWith(Response.ok().build());
    }

    private static boolean isOptionsRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null && request.getMethod().equalsIgnoreCase("OPTIONS");  
    } 

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        if (request.getHeaderString("Origin") == null)  return;
        if (isOptionsRequest(request)) {
            response.getHeaders().add("Access-Control-Allow-Credentials",   "true");
            response.getHeaders().add("Access-Control-Allow-Methods",       "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.getHeaders().add("Access-Control-Allow-Headers",       "X-Requested-With, Authorization, Accept-Version, Content-MD5, CSRF-Token, Content-Type, Range,X-API-KEY");
        }
            response.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
    
}
