package com.itrail.test.service;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.BaseResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    private static final Marker EXCEMPLE = MarkerManager.getMarker("EXC").setParents(QUERY_MARKER);
    
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


    public BaseResponse<List<LogView>> getFoundLogJPQL(FilterLog filterLog) throws Exception {
        BaseResponse<List<LogView>> f = new BaseResponse(0, "success");
        f.setData(entityManager.createQuery("SELECT e FROM LogView e WHERE e.levels = :infoFilter"
                                            + " AND ((:dateFromFilter is null or e.date >= :dateFromFilter)"
                                            + " AND (:dateToFilter is null or e.date <= :dateToFilter))")
                //.setParameter("idFilter", filterLog.getId())
                .setParameter("dateFromFilter", filterLog.getDateFrom())
                .setParameter("dateToFilter", filterLog.getDateTo())
                .setParameter("infoFilter", filterLog.getlevel().toString())
                .setMaxResults(filterLog.getLimit())
                .setFirstResult(filterLog.getOffset())
                .getResultList()); 
        return f;
    }
    
    public BaseResponse<List<LogView>> getFoundLogSQL(FilterLog filterLog) throws Exception{
        BaseResponse<List<LogView>> f = new BaseResponse(0,"success");
        try{
        f.setData(entityManager.createNativeQuery("SELECT * from LOGGERSTABLE a where a.levels = ?1 AND ((?2 is null or a.date >= ?2) AND (?3 is null or a.date <= ?3))")
                                            .setParameter(2, filterLog.getDateFrom())
                                            .setParameter(3, filterLog.getDateTo())
                                            .setParameter(1, filterLog.getlevel().toString())
                                            .setMaxResults(filterLog.getLimit())
                                            .setFirstResult(filterLog.getOffset())
                                            .getResultList()); //через SQL 
        }catch(Exception e){
            LOGGER.error(QUERY_MARKER, e.getMessage());
            LOGGER.info(SQL_MARKER, e.getMessage());
            LOGGER.trace(EXCEMPLE, Arrays.toString(e.getStackTrace()));  
            LOGGER.trace(SQL_MARKER,Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
        return f;
    }
    
    public BaseResponse<List<LogView>> getFoundlogJPA(FilterLog filterLog) throws Exception{
        BaseResponse<List<LogView>> f = new BaseResponse(0,"success");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LogView> logViewCriteria = cb.createQuery(LogView.class);
        Root<LogView> logViewRoot = logViewCriteria.from(LogView.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if ( null != filterLog.getDateFrom() ) predicates.add( cb.greaterThanOrEqualTo(logViewRoot.get("date"), filterLog.getDateFrom()));
        if ( null != filterLog.getDateTo() ) predicates.add( cb.lessThanOrEqualTo(logViewRoot.get("date"), filterLog.getDateTo()));
        if( null!= filterLog.getlevel() ) predicates.add(logViewRoot.get("levels").in(filterLog.getlevel().toString()));
        if(!predicates.isEmpty()){
            logViewCriteria.select(logViewRoot).where(predicates.toArray(new Predicate[]{}));
        }
        f.setData(entityManager.createQuery(logViewCriteria)                     
                               .setFirstResult(filterLog.getOffset())
                               .setMaxResults(filterLog.getLimit())
                               .getResultList());
        return f; 
    }  
}