package com.itrail.testik;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author barysevich_k
 */
public class UserTest {
    
    public UserTest() {
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
//    public void delTestUser() throws IOException{
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/entitymanager/1"))
//                                     .header("Content-Type", "application/json")
//                                     .DELETE()
//                                     .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//          .thenApply(HttpResponse::body)
//          .thenAccept(System.out::println).join();
//        }
//    @Test
//    public void getTestUser() throws IOException{
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                                         .uri(URI.create("http://127.0.0.1:8080/rest/api/entitymanager"))
//                                         .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//              .thenAccept(System.out::println)
//              .join(); 
//    }
//    @Test
//    public void postTestUser() throws IOException{
//        Map<Object, Object> data = new HashMap<>();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/entitymanager/3/Mouse"))
//                                     .header("Content-Type", "application/json")
//                                     .POST(BodyPublishers.ofString(data.toString()))
//                                     .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//          .thenApply(HttpResponse::body)
//          .thenAccept(System.out::println).join();
//    }
    
}
