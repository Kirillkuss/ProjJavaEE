
package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;
/**
 *
 * @author barysevich_k
 */
public class InstantDeserializer extends JsonDeserializer<Instant>{

    @Override
    public Instant deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
         return Instant.parse(jp.getText());
    }
}
