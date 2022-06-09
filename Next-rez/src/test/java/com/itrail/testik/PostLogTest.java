package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.LogData;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
public class PostLogTest {
    
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


//    @Test
//    public void getLogTest() throws IOException {
//         CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//         HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/rest/api/log");
//         CloseableHttpResponse response = null;
//         try{
//            response = httpClient.execute(httpGet);
//            HttpEntity responseEntity = response.getEntity();
//            System.out.println("Status:" + response.getStatusLine());
//            if (responseEntity != null){
//                    System.out.println("GET:" + EntityUtils.toString(responseEntity));
//                }                  
//        }catch(ClientProtocolException e){
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            try {
//		if (httpClient != null) httpClient.close();	
//		if (response != null) response.close();	
//            }catch(Exception e) {
//            e.printStackTrace();
//            }
//        }
//    }
    
    @Test
    public void postLogTestUserLog() throws IOException{
        String p = "{\"level\":\"INFO\","
                 + "\"marker\":\"NeedDate\","
                 + "\"message\":\"examples\","
                 + "\"date\":\"2022-05-02T11:36:37.932+03\"}";
        
        Map<String, String> formData = new HashMap<>();
        formData.put("level", "INFO");
        formData.put("marker", "NeedDate");
        formData.put("message", "examples");
        formData.put("date", "2022-05-02T11:36:37.932+03");
        ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(formData);
            
        LogData data = new LogData();
        data.setLevel(Level.INFO);
        data.setMarker("MMMM");
        data.setMessage("Test Post Logger");
        data.setParams(new Object[] {2});
        data.setDate(LocalDateTime.now());

        ObjectMapper objectMapperTwo = new ObjectMapper();
            String requestBodyTwo = objectMapperTwo
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(data);   
            
        StringEntity entity = new StringEntity(requestBody, "UTF-8");
        StringEntity en = new StringEntity(p, "UTF-8");
        StringEntity ent = new StringEntity(requestBodyTwo, "UTF-8");
        
        System.out.println("Object>>>" + requestBodyTwo);
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/rest/api/log/UserLog");
        httpPost.setEntity(ent);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("Status: " + response.getStatusLine());
            if(responseEntity != null){
                System.out.println("POSTUserLog: " + EntityUtils.toString(responseEntity));
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(httpClient != null) httpClient.close();
                if(response != null) response.close();
            }catch(IOException e){
                e.printStackTrace();
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
            System.out.println("Status: " + response.getStatusLine());
            if(responseEntity != null){
                System.out.println("POSTJPQL: " + EntityUtils.toString(responseEntity));
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
        }catch(IOException e ){
            e.printStackTrace();
        }finally{
            try{
                if(httpClient != null) httpClient.close();
                if(response != null) response.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    
}
