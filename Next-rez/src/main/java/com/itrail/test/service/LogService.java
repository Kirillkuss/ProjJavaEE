package com.itrail.test.service;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
/**
 * @author barysevich_k
 */
@Stateless
public class LogService {
    private static final Logger LOGGER = LogManager.getLogger(LogService.class);
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_SELECT");
    private static final Marker EXCEMPLE = MarkerManager.getMarker("EXC");
    
    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    protected void init() {
    }

    @PreDestroy
    protected void destroy() {
    }

    public List<LogView> getAllLog() {
        return entityManager.createQuery("SELECT e FROM  LogView e").getResultList();
    }

    public void createLog(LogView... logi) {
        createLog(Arrays.asList(logi));
    }

    @Transactional
    public void createLog(List<LogView> logi) {
        logi.stream().forEach(s -> entityManager.merge(s));
    }

    public void createLog(LogView logi) {
        entityManager.merge(logi);
    }


    public BaseResponse<List<LogView>> getFoundLog(FilterLog filterLog) throws Exception {
        BaseResponse<List<LogView>> f = new BaseResponse(0, "success"); 
//        f.setData(entityManager.createQuery("SELECT e FROM LogView e WHERE e.date BETWEEN :dateFromFilter AND :dateToFilter AND e.levels = :infoFilter")
//                //.setParameter("idFilter", filterLog.getId())
//                .setParameter("dateFromFilter", filterLog.getDateFrom())
//                .setParameter("dateToFilter", filterLog.getDateTo())
//                .setParameter("infoFilter", filterLog.getInfo().toString())
//                .setMaxResults(filterLog.getLimit())
//                .setFirstResult(filterLog.getOffset())
//                .getResultList()); 
        try{
        f.setData(entityManager.createNativeQuery("SELECT *w from LOGGERSTABLE a where a.levels = ? AND a.date between ? and ?")
                                            .setParameter(2, filterLog.getDateFrom())
                                            .setParameter(3, filterLog.getDateTo())
                                            .setParameter(1, filterLog.getlevel().toString())
                                            .getResultList()); //через SQL 
        }catch(Exception e){
            LOGGER.error(QUERY_MARKER, e.getMessage());
            LOGGER.info(SQL_MARKER, "SqlMarker");
            LOGGER.trace(EXCEMPLE, "MarkerEXC");
            
            //LOGGER.trace(SQL_MARKER,Arrays.toString(e.getStackTrace()));
           // e.printStackTrace();
        }
        return f;
    }   
}
