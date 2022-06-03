package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;

/**
 *
 * @author barysevich_k
 */
public class InstantSerializer extends JsonSerializer<Instant>{

    @Override
    public void serialize(Instant t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeString(null == t ? "" : t.atOffset(ZoneOffset.UTC).toString());
    }
    
    
}
