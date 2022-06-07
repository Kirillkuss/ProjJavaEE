
package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.app.model.FilterLog;

import com.itrail.test.app.model.LogData;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 *юнит тест предназначен для тестирования GET and POST запросов с таблицей логгов
 * @author barysevich_k
 */
public class PostLoggerTest {
    
    public PostLoggerTest() {
    }
 
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Post запрос для тестирования добавления логга в таблицу пользователем по параметрам:
     * 1. Уровень сообщения
     * 2. Маркер
     * 3. Сообщение
     * 4. Параметры
     * 5. Дата и время
     * @throws ClientProtocolException
     * @throws IOException 
     */
//    @Test
//    public void postLogTest() throws ClientProtocolException, IOException{
//        
//    ObjectMapper objectMapper = new ObjectMapper();
//    LogData data = new LogData();
//    data.setLevel(Level.INFO);
//    data.setMarker("MARK");
//    data.setMessage(null);
//    data.setParams(null);
//    data.setDate(LocalDateTime.now());
//    
//    String requestBody = objectMapper
//          .writerWithDefaultPrettyPrinter()
//          .writeValueAsString(data);
//    
//    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/log/UserLog"))
//                                     .header("Content-Type", "application/json")
//                                     .POST(BodyPublishers.ofString(requestBody))
//                                     .build();
//    HttpClient.newHttpClient()
//              .sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//              .thenAccept(System.out::println);
//    }
    /**
     * Post запрос на поиск логгов в таблице по параметрам через JPQL:
     * 1. Время и дата с
     * 2. Время и дата до
     * 3. Уровень сообщения 
     * 4. Лимит
     * 5. Начало
     * @throws ClientProtocolException
     * @throws IOException 
     */
//   @Test
//    public void postLogTestJPQL() throws ClientProtocolException, IOException{  
//    ObjectMapper objectMapper = new ObjectMapper();
//    FilterLog data = new FilterLog();
//    String requestBody = objectMapper
//          .writerWithDefaultPrettyPrinter()
//          .writeValueAsString(data);
//    
//    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/log/requestJPQL"))
//                                     .header("Content-Type", "application/json")
//                                     .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                                     .build();
//    HttpClient.newHttpClient()
//              .sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)  
//              .thenAccept(System.out::println);
//    }
    /**
     * Get запрос поиск всех логгов в таблшице(старый метод)
     * @throws MalformedURLException
     * @throws IOException 
     */
    @Test
    public void getLog() throws MalformedURLException, IOException{
        URL url = new URL("http://127.0.0.1:8080/rest/api/log");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }
    /**
     * Get запрос поиск всех логгов в таблице
     * @throws Exception 
     */
    @Test
    public void getLogTest() throws Exception{  
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("http://127.0.0.1:8080/rest/api/log"))
                                         .build();
        client.sendAsync(request, BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join(); 
    }
}
