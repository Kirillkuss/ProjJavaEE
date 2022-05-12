
package com.itrail.test.rest.impl;

import com.itrail.test.domain.ServerTime;
import com.itrail.test.rest.DateTimeResource;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("dt")
public class DateTimeAPI implements DateTimeResource {
    
    
  @Override 
    public ServerTime dateServiceList() {
        return new ServerTime();
    }


    

  
}
