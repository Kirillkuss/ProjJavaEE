

package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itrail.test.app.core.LocalDateTimeDeserializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;

/**
 *
 * @author barysevich_k
 */
public class LogData {

//    private Level level;
//    private Marker marker;
    private String message;
    private Object[] params;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(value    = "Время до",
                      name     = "date",
                      dataType = "String",
                      example  = "2022.06.18 11:02:42")
    private LocalDateTime date;

    public LogData() {
    }



    public String getMessage() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 41 * hash + Objects.hashCode(this.message);
        hash = 41 * hash + Arrays.deepHashCode(this.params);
        hash = 41 * hash + Objects.hashCode(this.date);
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
        if (!Arrays.deepEquals(this.params, other.params)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    
    
    
    
}
