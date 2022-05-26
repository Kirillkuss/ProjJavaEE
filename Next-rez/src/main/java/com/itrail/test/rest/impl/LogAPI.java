package com.itrail.test.rest.impl;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogResponse;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.LogResource;
import com.itrail.test.service.LogService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("log")
public class LogAPI implements LogResource{
    
    @EJB LogService service;
    @Override
    public BaseResponse getLog() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAllLog());
        //System.out.println(service.getAllLog());
       return bs;
    }

    @Override
    public LogResponse getListFilterLog(FilterLog filterLog) throws Exception {
        BaseResponse <List<LogView>> bs = service.getFoundLog(filterLog);
        return new LogResponse(service.getFoundLog(filterLog).getData());
    } 

}
