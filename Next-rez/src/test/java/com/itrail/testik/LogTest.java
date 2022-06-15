package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.domain.BaseResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime; 
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    private static final Marker PARAMS_MARKER = MarkerManager.getMarker("PARAMS");
    
    @PersistenceContext
    private EntityManager entityManager;
    
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
        data.setDate(LocalDateTime.of(2022, 10 , 4, 13, 40, 33,99935345));
        return data;
    }
 
    private <T> T getString( InputStream is, Class<T> cls ) throws IOException {
        return new ObjectMapper().readValue( getString(is) , cls );
    }

    private String getString( InputStream is ) throws IOException {
        String result = null;
        byte[] buffer = new byte[4096];     
        try ( ByteArrayOutputStream os = new ByteArrayOutputStream(); ){
            Integer len;
            while (( len = is.read(buffer) ) != -1) os.write(buffer, 0, len); 
            result = new String(os.toByteArray());
        }    
            return result;
    }

    @Test
    public void postLogUser() throws Exception{
        LogData data = createLogData();
        assertNotNull(data);
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = createURLPost();      
        BaseResponse bs = new BaseResponse();
        bs.setCode(200);
        bs.setMessage("success");
        bs.setData(data);
        
        assertEquals(url.toString() ,"http://127.0.0.1:8080/rest/api/log/UserLog" ); 
        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput( true );
            con.setRequestProperty("Content-Type", "application/json;charset=utf8");
            OutputStream out = con.getOutputStream();
            out.write( objectMapper.writeValueAsBytes( data ) );
            assertEquals( con.getResponseCode(), 200 );
            if ( 200 == con.getResponseCode() ) {
                String response = getString( con.getInputStream() );
                assertEquals( response, objectMapper.writeValueAsString( bs ) );    
            } else {
                String response = getString( con.getErrorStream() );
                assertNotNull( response );
            }
        }catch(IllegalArgumentException | MalformedURLException ex){
            ex.printStackTrace( System.err );
        }catch(ConnectException ex){
            ex.getMessage();
        }catch(NoSuchElementException | IOException ex){
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
                    Stream<String> s = reader.lines();
                    Iterator<String> it = s.iterator();
                    while(it.hasNext()){
                    assertNotNull(it.next());
                    }
                }
            }else {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader( con.getErrorStream() ))){
                    assertNotNull(reader.readLine()); }
            }   
        }catch(IllegalArgumentException | MalformedURLException ex){
            ex.printStackTrace( System.err );
        }catch(ConnectException ex){
            ex.getMessage();
        } catch(NoSuchElementException | IOException ex){
            ex.printStackTrace( System.err );
        }
    }           
}

