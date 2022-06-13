package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.service.LogService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Этот класс предназначен для тестирования GET and POST
 * запросов к логгам
 * @author barysevich_k
 */
public class LogTest {
    @EJB LogService service;
    private static final Marker PARAMS_MARKER = MarkerManager.getMarker("PARAMS");
    
    public LogTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Этот метод предназначен для тестирования GET запроса
     * @throws Exception 
     */
    @Test
    public void getLog() throws Exception {
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/log");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            assertEquals( huc.getResponseCode(), 200 );
            if( 200 == huc.getResponseCode() ){
                try ( BufferedReader reader = new BufferedReader( new InputStreamReader( huc.getInputStream() ))) {
                    assertNotEquals( reader.readLine(), null);
                }
            }else {
                try ( BufferedReader reader = new BufferedReader( new InputStreamReader( huc.getErrorStream() ))){
                    assertEquals( reader.readLine(), "RESTEASY003210: Could not find resource for full path: " + url.toString() );
                } 
            }
        }catch(IllegalArgumentException | MalformedURLException ex){
            ex.printStackTrace( System.err );
        }catch(ConnectException ex){  
             ex.getMessage();
        }catch(IOException e){
            e.printStackTrace( System.err );
        }
    }
    
    public URL createURLPost() throws MalformedURLException{
        URL url = new URL("http://127.0.0.1:8080/rest/api/log/UserLog");
        return url;
    }

    public LogData createLogData(){
        LogData data = new LogData();
        data.setLevel(Level.INFO);
        data.setMarker(PARAMS_MARKER);
        data.setMessage("Test Post Logger");
        data.setParams(new Object[] {2});
        data.setDate(LocalDateTime.now());
        return data;
    }
     /**
     * Этот метод предназначен для тестирования POST запроса с параметрами объекта,
     * при котором пользователь создает свой лог.
     * @see com.itrail.test.app.model.LogData
     * @throws Exception 
     */
    @Test
    public void postLogUser() throws Exception{
        LogData data = createLogData();
        assertNotNull(data);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = createURLPost();
        assertEquals(createURLPost().toString() ,"http://127.0.0.1:8080/rest/api/log/UserLog" ); 
        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput( true );
            con.setRequestProperty("Content-Type", "application/json;charset=utf8");
            OutputStream out = con.getOutputStream();
                         out.write( objectMapper.writeValueAsBytes( data ));
            assertEquals( con.getResponseCode(), 200 );             
            if ( 200 == con.getResponseCode() ) {    
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader( con.getInputStream() ))) {
                    assertEquals( reader.readLine(),"{\"code\":200,\"message\":\"success\",\"data\":" + objectMapper.writeValueAsString(data) + "}"); 
                }       
            } else {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader( con.getErrorStream() ))) {
                    //while (reader.readLine() != null ){
                    assertEquals( reader.readLine(), "RESTEASY003210: Could not find resource for full path: " + url.toString() ); }
            }
        }catch(IllegalArgumentException | MalformedURLException ex){
            ex.printStackTrace( System.err );
        }catch(ConnectException ex){
            ex.getMessage();
        }catch(IOException ex){
            ex.printStackTrace( System.err );
        }  
    }
    /**
     * Этот метод предназначен для тестирования POST запроса с параметрами объекта,
     * при котором получаем список логгов по заданным параметрам.
     * @see com.itrail.test.app.model.FilterLog
     * @throws Exception 
     */
    @Test
    public void postLogJPQL() throws Exception{
        FilterLog filterlog = new FilterLog();
        filterlog.setId(Long.MIN_VALUE);
        filterlog.setlevel(Level.INFO);
        filterlog.setLimit(100);
        filterlog.setOffset(0);
        filterlog.setDateFrom(LocalDateTime.now().minusDays(1));
        filterlog.setDateTo(LocalDateTime.now().plusDays(1));
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/log/requestJPQL");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json;charster=utf8");
            OutputStream out = con.getOutputStream();
            out.write( objectMapper.writeValueAsBytes(filterlog) );
            assertEquals( con.getResponseCode(), 200 );
            if ( 200 == con.getResponseCode() ){
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader( con.getInputStream() ))){
                    assertNotEquals( reader, null); }
            }else {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader( con.getErrorStream() ))){
                    assertEquals(reader.readLine(), "RESTEASY003210: Could not find resource for full path: " + url.toString()); }
            }
        }catch(IllegalArgumentException | MalformedURLException ex){
            ex.printStackTrace( System.err );
        }catch(ConnectException ex){
            ex.getMessage();
        }catch(IOException ex){
            ex.printStackTrace( System.err );
        }
    } 
}
