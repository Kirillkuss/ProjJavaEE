package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import com.itrail.test.domain.BaseResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.NoSuchElementException;
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
 *
 * @author barysevich_k
 */
public class TestObjectLog {
    public static final Marker MAR = MarkerManager.getMarker("SALAM");
    
    public TestObjectLog() {
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
    
//    public LogData createLogData(){
//       LogData data = new LogData();
//       data.setId(Long.MAX_VALUE);
//       data.setLevel(Level.INFO);
//       data.setMarker(MAR);
//       data.setParams(new Object[] {3434});
//       data.setMessage("Object Test Log");
//       data.setDate(LocalDateTime.of(2022, Month.MARCH, 1, 12, 40, 10, 99935345));
//       return data;
//    }
//    
//    
//    public URL createURL() throws IOException{
//        URL url = new URL("http://127.0.0.1:8080/rest/api/log/UserLog");
//        return url;
//    }
//    
//    public String getRequset() throws Exception{
//        return "POST";
//    }
//        
//    public <T> T getString(InputStream is, Class<T> cls) throws IOException{
//        return new ObjectMapper().readValue(is, cls);
//    }
//    
//    public FilterLog getFilterLog(){
//        FilterLog f = new FilterLog();
//        f.setlevel(Level.INFO);
//        f.setLimit(1);
//        f.setOffset(0);
//        f.setDateFrom( LocalDateTime.of( 2022, Month.FEBRUARY, 1, 12, 40, 10, 99935345 ).minusDays(1) );
//        f.setDateTo( LocalDateTime.of( 2022, Month.APRIL, 1, 12, 40, 10, 99935345 ).plusDays(1) );
//    return f;
//    }  
 
//   public BaseResponse getBS()  throws Exception{
//        try{
//            LogData logData = createLogData();
//            URL url = createURL();
//            ObjectMapper objectMapper = new ObjectMapper();
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setDoOutput(true);
//            con.setRequestProperty( "Content-Type", "application/json;charset=utf8" );
//            con.setRequestMethod( getRequset() );
//            OutputStream out =con.getOutputStream();
//            out.write( objectMapper.writeValueAsBytes( logData ));
//            BaseResponse bs = objectMapper.readValue( con.getInputStream(), BaseResponse.class );
//            return bs;
//        }catch( ConnectException ex ){
//            return BaseResponse.error( 999, ex );
//        }catch( IOException ex ){
//            return BaseResponse.error( 999, ex );
//        }
//    } 
//
//    @Test
//    public void postLogJPA() throws Exception{
//        FilterLog filterlog = getFilterLog();
//        BaseResponse ObjectTwo = getBS();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try{
//            URL url = new URL( "http://127.0.0.1:8080/rest/api/log/requestJPA" );
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setDoOutput( true );
//            con.setRequestProperty( "Content-Type", "application/json;charster=utf8" );
//            con.setRequestMethod( getRequset() );
//            OutputStream out = con.getOutputStream();
//            out.write( objectMapper.writeValueAsBytes(filterlog) );
//            BaseResponse objectOne = objectMapper.readValue(con.getInputStream(), BaseResponse.class );
//            assertEquals( objectOne, ObjectTwo );
//        }catch( IllegalArgumentException | MalformedURLException ex ){
//            ex.getMessage();
//        }catch( ConnectException ex ){
//            ex.getMessage();
//        } catch( NoSuchElementException | IOException ex ){
//            ex.getMessage();
//        }
//    }
      
}
