
package com.itrail.test.app.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itrail.test.app.core.InstantDeserializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import org.apache.logging.log4j.Level;
/**
 *
 * @author barysevich_k
 */
public class LogData {
    @ApiModelProperty(value    = "level",
                      name     = "level",
                      dataType = "String",
                      example  = "INFO")
    private Level level;
    
    @ApiModelProperty(value    = "marker",
                      name     = "marker",
                      dataType = "String",
                      example  = "MARKER")
    //private Marker marker;
    private String marker;
    @ApiModelProperty(value    = "message",
                      name     = "message",
                      dataType = "String",
                      example  = "user message")
    private String message;
    
    @ApiModelProperty(value    = "params",
                      name     = "params")
    private Object[] params;
    
    @JsonDeserialize(using = InstantDeserializer.class)
    @ApiModelProperty(value    = "Время",
                      name     = "date",
                      dataType = "String",
                      example  = "2022-06-02T11:36:37.932Z")
    private Instant date;

    public LogData() {
        
    }

    public LogData(Level level, String marker, String message, Object[] params, Instant date) {
        this.level = level;
        this.marker = marker;
        this.message = message;
        this.params = params;
        this.date = date;
    }

    public String getmarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
    
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getmessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.level);
        hash = 89 * hash + Objects.hashCode(this.marker);
        hash = 89 * hash + Objects.hashCode(this.message);
        hash = 89 * hash + Arrays.deepHashCode(this.params);
        hash = 89 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogData other = (LogData) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        if (!Objects.equals(this.marker, other.marker)) {
            return false;
        }
        if (!Arrays.deepEquals(this.params, other.params)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    
}
