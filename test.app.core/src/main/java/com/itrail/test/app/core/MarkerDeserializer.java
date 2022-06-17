package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
/**
 *
 * @author barysevich_k
 */
public class MarkerDeserializer extends JsonDeserializer<Marker>{

    @Override
    public Marker deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        Marker marker  = MarkerManager.getMarker(jp.getText());
        return MarkerManager.getMarker(marker.getName());
    }
    
    
}
