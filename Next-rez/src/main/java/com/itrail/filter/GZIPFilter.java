package com.itrail.filter; 
import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author barysevich_k
 */
@WebFilter(filterName ="gzipFilter",
           urlPatterns = {"/*"},
           dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
           initParams = @WebInitParam(name = "fileTypes", value = "doc;xls;zip;txt;jpg;png;gif;json;xml;html"))
public class GZIPFilter implements javax.servlet.Filter {
    
    private static final Logger LOGGER = LogManager.getLogger(GZIPFilter.class);
 @Override
    public void destroy() { 
        LOGGER.log(Level.INFO,"Destroying GZIPFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.log(Level.INFO,"Remote host" + request.getRemoteHost());
        chain.doFilter(request, response);
    }   
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       LOGGER.log(Level.INFO, "Initializing GZIPFilter");
    } 
}


