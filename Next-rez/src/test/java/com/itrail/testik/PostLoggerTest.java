
package com.itrail.testik;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.itrail.test.app.model.LogData;
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.logging.log4j.Level;
//import io.swagger.annotations.ApiModelProperty;
//import java.time.LocalDateTime;
//import org.apache.logging.log4j.Marker;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
/**
 * Для Java 11
 *юнит тест предназначен для тестирования GET and POST запросов с таблицей логгов
 * @author barysevich_k
 */
public class PostLoggerTest {   
//    public PostLoggerTest() {
//    }
// 
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
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
//        LogData data = new LogData();
//            data.setLevel(level);
//            data.setMarker("MMMM");
//            data.setmessage("Test Post Logger");
//            data.setParams(new Object[] {2});
//            data.setDate(LocalDateTime.now());
//            
//            
//        ObjectMapper objectMapperTwo = new ObjectMapper();
//            String requestBodyTwo = objectMapperTwo
//                .writerWithDefaultPrettyPrinter()
//                .writeValueAsString(data);
//            System.out.println("requestBodyTwo>>>>>" + requestBodyTwo);
//            
//        Map<String, String> formData = new HashMap<>();
//            formData.put("level", "INFO");
//            formData.put("marker", "NeedDate");
//            formData.put("message", "examples");
//            formData.put("date", "2022-05-02T11:36:37.932+03");
//        ObjectMapper objectMapper = new ObjectMapper();
//            String requestBody = objectMapper
//                .writerWithDefaultPrettyPrinter()
//                .writeValueAsString(formData);
//            
//        String p = "{\"level\":\"INFO\","
//                 + "\"marker\":\"NeedDate\","
//                 + "\"message\":\"examples\","
//                 + "\"date\":\"2022-05-02T11:36:37.932+03\"}";
//        
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/log/UserLog"))
//                                         .header("Content-Type", "application/json")
//                                         .POST(HttpRequest.BodyPublishers.ofString(requestBodyTwo))
//                                         .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//              .thenAccept(System.out::println)
//              .join();
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
//
//        String m = "{\"id\":\"1\","
//                 + "\"dateFrom\":\"2022-03-02T11:36:37.932Z\","
//                 + "\"dateTo\":\"2022-09-02T11:36:37.932Z\","
//                 + "\"limit\":\"100\","
//                 + "\"offset\":\"0\","
//                 + "\"level\":\"INFO\"}";
//    
//        HttpClient client= HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/log/requestJPQL"))
//                                     .header("Content-Type", "application/json")
//                                     .POST(HttpRequest.BodyPublishers.ofString(m))
//                                     .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)  
//              .thenAccept(System.out::println)
//              .join();
//    }
    /**
     * Get запрос поиск всех логгов в таблице
     * @throws Exception 
     */
//    @Test
//    public void getLogTest() throws Exception{  
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                                         .uri(URI.create("http://127.0.0.1:8080/rest/api/log"))
//                                         .build();
//        client.sendAsync(request, BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//              .thenAccept(System.out::println)
//              .join(); 
//    }
}
