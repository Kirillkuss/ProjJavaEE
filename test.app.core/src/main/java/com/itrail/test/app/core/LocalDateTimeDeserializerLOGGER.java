
package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author barysevich_k
 */
public class LocalDateTimeDeserializerLOGGER extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(jp.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
       // return LocalDateTime.parse( jp.getText(),DateTimeFormatter.ISO_ZONED_DATE_TIME); 
    }  
}
