package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.FilterLog;
import com.itrail.test.app.model.LogData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
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
public class LogTest {
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
    
    @Test
    public void getLog() throws IOException {
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/log");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream()))) {
                System.out.println( "GET>>>" + reader.readLine() );
            }
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void postLogUser() throws  FileNotFoundException,IOException{
        LogData data = new LogData();
        data.setLevel(Level.INFO);
        data.setMarker(PARAMS_MARKER);
        data.setMessage("Test Post Logger");
        data.setParams(new Object[] {2});
        data.setDate(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/log/UserLog1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput( true );
            con.setRequestProperty("Content-Type", "application/json;charset=utf8");
            OutputStream out = con.getOutputStream();
                         out.write( objectMapper.writeValueAsBytes(data) );            
            if ( 200 == con.getResponseCode() ) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader( con.getInputStream() ))) {
                    System.out.println( "POST_UserLog>>>" + reader.readLine() );
                }
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader( con.getErrorStream() ))) {
                    System.out.println( "Error>>>" + reader.readLine() );
                }
            }          
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
    }
    
    @Test
    public void postLogJPQL() throws IOException{
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
            try(BufferedReader reader = new BufferedReader(new InputStreamReader( con.getInputStream() ))){
                System.out.println( "POST_JPQL: " + reader.readLine() );
            }
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
    }
   
}
