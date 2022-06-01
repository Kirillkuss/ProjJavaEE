package com.itrail.test.rest.impl;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogResponse;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.LogResource;
import com.itrail.test.service.LogService;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import org.apache.logging.log4j.Level;
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
    public LogResponse getListFilterLogJPQL(FilterLog filterLog) throws Exception {
        //BaseResponse <List<LogView>> bs = service.getFoundLog(filterLog);
        return new LogResponse(service.getFoundLogJPQL(filterLog).getData());
    }

    @Override
    public LogResponse getListFilterLogSQL(FilterLog filterLog) throws Exception {
        //BaseResponse <List<LogView>> bs = service.getFoundLog(filterLog);
        return new LogResponse(service.getFoundLogSQL(filterLog).getData());
    }

    @Override
    public BaseResponse getListLogJPA(FilterLog filterLog) throws Exception {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getFoundlogJPA(filterLog).getData());
        return bs;
    }

    @Override
    public BaseResponse getListLogSubQuery(FilterLog filterLog) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getFoundLogSubQuery(filterLog).getData());
        return bs;
    }

    @Override
    public BaseResponse getExample(Long id, Level level) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getExample(id,level).getData());
        return bs;
    }

    @Override
    public BaseResponse getDateTimeLog(String date) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getLog(date).getData());
        return bs;
        
    }
    
    
    
}
