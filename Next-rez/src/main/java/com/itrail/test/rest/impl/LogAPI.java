package com.itrail.test.rest.impl;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.app.model.LogResponse;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.LogResource;
import com.itrail.test.service.LogService;
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
       return bs;
    }
    
    @Override
    public LogResponse getListFilterLogJPQL(FilterLog filterLog) throws Exception {
        return new LogResponse(service.getFoundLogJPQL(filterLog).getData());
    }

    @Override
    public LogResponse getListFilterLogSQL(FilterLog filterLog) throws Exception {
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
        try {
            bs.setData(service.getFoundLogSubQuery(filterLog).getData()); 
        }catch (Exception ex) {
            return BaseResponse.error(999, ex);
        }
        return bs;
    }

    @Override
    public BaseResponse getExample(Long id, Level level) {
        BaseResponse bs = new BaseResponse(200, "success");
        try {
            bs.setData(service.getExample(id,level).getData());
        } catch (Exception ex) {
            return BaseResponse.error(999, ex);
        }
        return bs;
    }

    @Override
    public BaseResponse setLog(LogData data) {
        BaseResponse bs = new BaseResponse(200, "success");
        try{
        service.createLog(new LogView(null,data.getDate(), data.getLevel().toString(), data.getMessage(),data.getMarker().toString(), data.getParams()));
        bs.setData(data);
        }catch(Exception ex){
           return BaseResponse.error(999, ex);
        }
        return bs;
    }  

}
