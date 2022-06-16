package com.itrail.testik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
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
    
    public String getResponse(InputStream inputstream) throws IOException{
        String result = null;
        byte[] b = new byte[4096];
        try( ByteArrayOutputStream os = new ByteArrayOutputStream() ){
            Integer len;
            while((len = inputstream.read(b)) != -1 ) os.write(b,0, len);
            result = new String(os.toByteArray());
          return result;
        }catch(ConnectException ex){
            return ex.getMessage();
        }catch(IOException ex){
           return ex.getMessage(); 
        } 
    }
    
    public User createUser(){
        User user = new User();
        user.setIdUser(25);
        user.setName("KIRILL");
        user.setLogin("User@mail.ru");
        user.setPhone("+375298956190");
        user.setWallet(BigDecimal.valueOf(43434.0));
        user.setAnimal(null);
        return user;
    }
    


    @Test
    public void getUser() throws IOException {
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/entitymanager");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            assertEquals(con.getResponseCode(), 200);
            if( 200 == con.getResponseCode() ){
               String response = getResponse(con.getInputStream());
               assertNotNull(response);
            }else{
                String response = getResponse(con.getErrorStream());
                assertNotNull(response);
            }
        }catch (ConnectException er){
            er.getMessage();
        }catch(IOException er){
           er.printStackTrace(System.err);
        } 
    }
    
    @Test
    public void putUser() throws IOException{
        User user = createUser();
        BaseResponse bs = new BaseResponse();
        bs.setCode(200);
        bs.setMessage("success");
        bs.setData(user);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("http://127.0.0.1:8080/rest/api/entitymanager/create");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput( true );
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json;charset=utf8");
            OutputStream out = con.getOutputStream();
            out.write( objectMapper.writeValueAsBytes(user) );
            assertEquals(con.getResponseCode(), 200);
            if ( 200 == con.getResponseCode() ){
                String response = getResponse(con.getInputStream());
                assertEquals(response, objectMapper.writeValueAsString(bs));
            }else{
                String response = getResponse(con.getErrorStream());
                assertNotNull(response);
            }
        }catch(ConnectException ex){
            ex.getMessage();
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
 
    }
}
