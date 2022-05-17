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
import org.hibernate.QueryException;

/**
 *
 * @author barysevich_k
 */
@Stateless
public class LogService {
    
    private static final Logger LOGGER = LogManager.getLogger(LogService.class);

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

    
    public BaseResponse<List<LogView>> getFoundLog(FilterLog filterLog) {
        BaseResponse<List<LogView>> f = new BaseResponse(0, "success"); 
        try{
        f.setData(entityManager.createQuery("SELECT e FROM LogView e WHERE e.date BETWEEN :dateFromFilter AND :dateToFilter AND e.levels = :infoFilter")
                //.setParameter("idFilter", filterLog.getId())
                .setParameter("dateFromFilter", filterLog.getDateFrom())
                .setParameter("dateToFilter", filterLog.getDateTo())
                .setParameter("infoFilter", filterLog.getInfo())
                .setMaxResults(filterLog.getLimit())
                .setFirstResult(filterLog.getOffset())
                .getResultList());
        }catch(Exception e){
           // f.setMessage(e.getMessage());
            LOGGER.error(e.getMessage());  
        }
 
//        f.setData(entityManager.createNativeQuery("SELECT *sa from LOGGERSTABLE e;")
//                                                // where e.date between :dateFromFilter and :dateToFilter
//                                           // .setParameter("dateFromFilter", filterLog.getDateFrom())
//                                            //.setParameter("dateToFilter", filterLog.getDateTo())
//                                            .getResultList()); //через SQL 
        return f;
    }
    
}
