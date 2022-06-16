package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.LogData;
import com.itrail.test.domain.BaseResponse;
import java.io.IOException;
import java.net.ConnectException;
import java.time.LocalDateTime;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
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
 *java 8  через org.apache.http
 * @author barysevich_k
 */
public class PostLogTest {
     private static final Marker PARAMS_MARKER = MarkerManager.getMarker("PARAMS");
    
    public PostLogTest() {
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
    public void getLogTest() throws IOException {
         CloseableHttpClient httpClient = HttpClientBuilder.create().build();
         HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/rest/api/log");
         CloseableHttpResponse response = null;
         try{
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            assertNotNull(responseEntity);                   
        }catch(ClientProtocolException e){
            e.printStackTrace(System.err);
        }catch(ConnectException e){
            e.getMessage();
        }catch(IOException e){
            e.printStackTrace(System.err);
        }finally{
            try {
		if (httpClient != null) httpClient.close();	
		if (response != null) response.close();	
            }catch(IOException e) {
            e.printStackTrace(System.err);
            }
        }
    }
    
    @Test
    public void postLogTestUserLog() throws IOException{
        LogData data = new LogData();
        data.setLevel(Level.INFO);
        data.setMarker(PARAMS_MARKER);
        data.setMessage("Test Post Logger");
        data.setParams(new Object[] {2});
        data.setDate(LocalDateTime.now());
        
        BaseResponse bs = new BaseResponse();
        bs.setCode(200);
        bs.setMessage("success");
        bs.setData(data);
        
        ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                .writeValueAsString(data);   
        StringEntity ent = new StringEntity(requestBody, "UTF-8");
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/rest/api/log/UserLog");
        httpPost.setEntity(ent);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            assertEquals(objectMapper.writeValueAsString(bs), EntityUtils.toString(responseEntity));
        }catch(ConnectException e){
            e.getMessage();
        }catch(IOException e){
            e.printStackTrace(System.err);
        }finally{
            try{
                if(httpClient != null) httpClient.close();
                if(response != null) response.close();
            }catch(IOException e){
                e.printStackTrace(System.err);
            }
        }
    }
    
    @Test
    public void getLogTestJPQL() throws IOException{
        String m = "{\"id\":\"1\","
         + "\"dateFrom\":\"2022-03-02T11:36:37.932Z\","
         + "\"dateTo\":\"2022-09-02T11:36:37.932Z\","
         + "\"limit\":\"100\","
         + "\"offset\":\"0\","
         + "\"level\":\"INFO\"}";
        StringEntity entity = new StringEntity(m, "UTF-8");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/rest/api/log/requestJPQL");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            assertNotNull(EntityUtils.toString(responseEntity));
        }catch(ConnectException e){
            e.getMessage();
        }catch(IOException e ){
            e.printStackTrace(System.err);
        }finally{
            try{
                if(httpClient != null) httpClient.close();
                if(response != null) response.close();
            }catch(IOException e){
                e.printStackTrace(System.err);
            }
        }
        
    }   
}
