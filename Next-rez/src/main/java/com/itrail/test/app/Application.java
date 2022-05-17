package com.itrail.test.app;
import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
/**
 * Configures JAX-RS for the application.
 *
 * @author barysevich_k
 */
@ApplicationPath("/api")
public class Application extends javax.ws.rs.core.Application {
    public Application(@Context ServletConfig servletconfig) {
  
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("REST API ");
        beanConfig.setBasePath("/rest/api");
        beanConfig.setSchemes( new String[]{"http","https"} );
        beanConfig.setResourcePackage("com.itrail.test.rest.impl");
        beanConfig.setScan(true);
    }
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return new HashSet();
    }

}
