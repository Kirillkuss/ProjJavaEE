
package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.apache.logging.log4j.Level;
/**
 *
 * @author barysevich_k
 */
public class LevelSerializer extends JsonSerializer<Level>{

    @Override
    public void serialize(Level t, JsonGenerator jg, SerializerProvider sp) throws IOException {
       jg.writeString(null == t ? "" : t.name()); 
    }  
}
