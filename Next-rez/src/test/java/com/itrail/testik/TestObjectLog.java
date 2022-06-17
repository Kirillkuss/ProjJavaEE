package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.LogData;
import com.itrail.test.domain.BaseResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
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
    
    public LogData createLogData(){
       LogData data = new LogData();
       data.setLevel(Level.INFO);
       data.setMarker(MAR);
       data.setParams(new Object[] {3434});
       data.setMessage("Object Test Log");
       data.setDate(LocalDateTime.of(2022, Month.MARCH, 1, 12, 40, 10, 99935345));
       return data;
    }
    
    
    public URL createURL() throws IOException{
        URL url = new URL("http://127.0.0.1:8080/rest/api/log/UserLog");
        return url;
    }
    
    public String getRequset() throws Exception{
        return "POST";
    }
        
    public <T> T getString(InputStream is, Class<T> cls) throws IOException{
        return new ObjectMapper().readValue(is, cls);
    }
    
        private String getString( InputStream is ) throws IOException {
        String result = null;
        byte[] buffer = new byte[4096];
        try ( ByteArrayOutputStream os = new ByteArrayOutputStream() ){
            Integer len;
            while (( len = is.read(buffer) ) != -1) os.write(buffer, 0, len);
            result = new String(os.toByteArray());
        }
        return result;
    }
     
    
    @Test
    public void testPostObject() throws IOException, ClassNotFoundException, Exception{
        try{

            LogData data = createLogData();
            URL url = createURL();
            ObjectMapper objectMapper = new ObjectMapper(); 
            BaseResponse bs2 = new BaseResponse(200,"success");
            
            bs2.setData(objectMapper.readValue(objectMapper.writeValueAsString(data), LogData.class));

            HttpURLConnection con = ( HttpURLConnection ) url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json;charset=utf8");
            con.setRequestMethod(getRequset());
            OutputStream out = con.getOutputStream();
            out.write(objectMapper.writeValueAsBytes(data));
               //BaseResponse bs = getString(con.getInputStream(),BaseResponse.class);
               BaseResponse bs = objectMapper.readValue(con.getInputStream(), BaseResponse.class);
        }catch( ConnectException ex ){
            ex.getMessage();
        }catch( IOException ex ){
            ex.getMessage();
        }
        }
    
}
