
package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 *
 * @author barysevich_k
 */
public class MarkerSerializer extends JsonSerializer<Marker>{

    @Override
    public void serialize(Marker marker, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeString(null == marker ? "" : marker.getName());
    }
    
    
}
