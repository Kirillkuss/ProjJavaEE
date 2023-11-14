
package com.itrail.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.domain.TotalFeatures;
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
public class TestStringApi {
    
    private final ObjectMapper om = new ObjectMapper();
    
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
    public void testOne() throws Exception{
        String request = "{\n" +
                         "    \"totalFeatures\": 1,\n" +
                         "    \"type\": \"FeatureCollection\",\n" +
                         "    \"features\": [\n" +
                         "        {\n" +
                         "            \"type\": \"Feature\",\n" +
                         "            \"geometry\": null,\n" +
                         "            \"properties\": {\n" +
                         "                \"NTO_NUMBER\": \"34545\",\n" +
                         "                \"ADM_NAME\": \"Выборгский\"\n" +
                         "            },\n" +
                         "            \"id\": \"NTO_OBJECT_INFO_ONLY.34545\",\n" +
                         "            \"geometry_name\": null\n" +
                         "        },\n" +
                         " {\n" +
                         "            \"type\": \"Feature\",\n" +
                         "            \"geometry\": null,\n" +
                         "            \"properties\": {\n" +
                         "                \"NTO_NUMBER\": \"34545\",\n" +
                         "                \"ADM_NAME\": \"Выборгский\"\n" +
                         "            },\n" +
                         "            \"id\": \"NTO_OBJECT_INFO_ONLY.34545\",\n" +
                         "            \"geometry_name\": null\n" +
                         "        },\n" +
                         " {\n" +
                         "            \"type\": \"Feature\",\n" +
                         "            \"geometry\": null,\n" +
                         "            \"properties\": {\n" +
                         "                \"NTO_NUMBER\": \"34545\",\n" +
                         "                \"ADM_NAME\": \"Выборгский\"\n" +
                         "            },\n" +
                         "            \"id\": \"NTO_OBJECT_INFO_ONLY.34545\",\n" +
                         "            \"geometry_name\": null\n" +
                         "        }\n" +
                         "    ]\n" +
                         "}";
        TotalFeatures respone = om.readValue( request, TotalFeatures.class );
    
    }
    
    
    @Test
    public void testTwo() throws Exception{
        String request = "{\n" +
                        "    \"totalFeatures\": 1,\n" +
                        "    \"type\": \"FeatureCollection\",\n" +
                        "    \"features\": [\n" +
                        "        {\n" +
                        "            \"type\": \"Feature\",\n" +
                        "            \"geometry\": null,\n" +
                        "            \"properties\": {\n" +
                        "                \"NTO_NUMBER\": \"34545\",\n" +
                        "                \"ADM_NAME\": \"Выборгский\"\n" +
                        "            },\n" +
                        "            \"id\": \"NTO_OBJECT_INFO_ONLY.34545\",\n" +
                        "            \"geometry_name\": null\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";
        TotalFeatures respone = om.readValue( request, TotalFeatures.class );
    }
}
