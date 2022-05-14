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

/**
 *
 * @author barysevich_k
 */
@Stateless
public class LogService {
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostConstruct
    protected void init(){ 
    }
 
    @PreDestroy
    protected void destroy(){   
    }
    
    public List<LogView> getAllLog(){
        return entityManager.createQuery("SELECT e FROM  LogView e").getResultList();
    }
    
    public void createLog(LogView...logi){
        createLog(Arrays.asList(logi));
    }
    
    @Transactional
    public void createLog(List<LogView> logi){
        logi.stream().forEach(s->entityManager.merge(s));
    }
    
    public void createLog(LogView logi){
       entityManager.merge(logi);
    }
    
    
    public BaseResponse<List<LogView>> getFoundLog(FilterLog filterLog){
        BaseResponse<List<LogView>> f = new BaseResponse(0, "success");
        try{
            f.setData(getFil());
            return f;
        } catch(Exception e){
            return BaseResponse.error(980, e);
        }

    }
    
    
    private List<LogView> getFil(){
        FilterLog fil = new FilterLog();
        return entityManager.createQuery("SELECT e FROM LogView e where :idFil is null or e.id = :idFil AND "
                + ":dateFil is null or e.date = :dateFil")
                .setParameter("idFil", fil.getId())
                .setParameter("dateFil", fil.getDate())
                .getResultList();  
    }
    
}