
package com.itrail.test.app.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
/**
 *
 * @author barysevich_k
 */
public class LocalDateTimeSerializerLOGGER extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime date, JsonGenerator jg, SerializerProvider sp) throws IOException {
       jg.writeString(null == date ? "" : date.atOffset(ZoneOffset.UTC).toString());
    }
}
