package com.itrail.testik;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
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


//     @Test
//     public void delTestUser() throws IOException{
//        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/rest/api/entitymanager/1"))
//                                     .header("Content-Type", "application/json")
//                                     .DELETE()
//                                     .build();
//        HttpClient.newHttpClient()
//              .sendAsync(request, HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//              .thenAccept(System.out::println);
//        }
    @Test
    public void getTestUser() throws IOException{
        HttpClient clientes = HttpClient.newHttpClient();
        HttpRequest requestes = HttpRequest.newBuilder()
                                         .uri(URI.create("http://127.0.0.1:8080/rest/api/entitymanager"))
                                         .build();
        clientes.sendAsync(requestes, HttpResponse.BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join(); 
    }
}
