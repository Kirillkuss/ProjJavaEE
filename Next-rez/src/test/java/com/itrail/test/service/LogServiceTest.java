package com.itrail.test.service;

import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.app.model.LogView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.apache.logging.log4j.Level;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
/**
 * этот класс для тестирования сервиса
 * @see com.itrail.test.service.LogService
 * @author barysevich_k
 */
@Ignore
@RunWith( JMockit.class )
public class LogServiceTest {
    
    @Tested     LogService    service;
    @Injectable EntityManager em;
    
    LogView       logView   = new LogView();
    List<LogView> listLog   = new ArrayList<>();
    FilterLog     filterLog = new FilterLog( 1L, LocalDateTime.now(), LocalDateTime.now(), 1, 1, Level.INFO );
    LogData       data      = new LogData();
    
    /**
     * Тестирование метода getAll()
     * @throws Exception 
     */
    @Test
    public void testGetAll() throws Exception{
        service.getAllLog();
    }
    /**
     * Тестирование метода createLog()
     * @throws Exception 
     */
    @Test
    public void testCreateLog() throws Exception{        
        service.createLog(logView);
        service.createLog( listLog );
    }
    /**
     * Тестирование метода getFoundLogJPQL()
     * @throws Exception 
     */
    //@Test
    public void testGetFoundLogJPQL() throws Exception{
        service.getFoundLogJPQL( filterLog );
    }
    /**
     * Тестирование метода getFoundLogSQL()
     * @throws Exception 
     */
    //@Test
    public void testGetFoundLogSQL() throws Exception{
        filterLog.setId( 1L );
        service.getFoundLogSQL( filterLog );
    }
    /**
     * Тестирование метода getFoundlogJPA()
     * @throws Exception 
     */
    @Test
    public void testGetFoundlogJPA() throws Exception{
        service.getFoundlogJPA(filterLog );        
    }
    /**
     * Тестирование метода getFoundLogSubQuery()
     * @throws Exception 
     */
    @Test
    public void testGetFoundLogSubQuery() throws Exception{
        service.getFoundLogSubQuery( filterLog );
    }
    /**
     * Тестирование метода getExample()
     * @throws Exception 
     */
    @Test
    public void testGetExample() throws Exception{
        service.getExample( 1L , Level.FATAL );
    }
    /**
     * Тестирование метода setLogParams()
     * @throws Exception 
     */
    @Test
    public void testSetLogParams() throws Exception{
        service.setLogParams( data );
    }
}
