package com.itrail.test.app.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LevelSerializer;
import com.itrail.test.app.core.LocalDateTimeDeserializerLOGGER;
import com.itrail.test.app.core.LocalDateTimeSerializerLOGGER;
import com.itrail.test.app.core.MarkerDeserializer;
import com.itrail.test.app.core.MarkerSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
/**
 *
 * @author barysevich_k
 */
public class LogData implements Serializable{
    //private final String uuid = /*прочитать о генерации UUID */ ; 
    /**
     * почитать аннотацию Json RofUn
     */
    /**
     *@ трансиелнт филт  
     */
    /**
     * key - serialzerObject generatedObjectvalueId
     */
    @ApiModelProperty(value    = "id",
                      name     = "id",
                      dataType = "Long",
                      example  = "1000")  
    private Long id;
    
    @JsonSerialize(using = LevelSerializer.class)
    @ApiModelProperty(value    = "level",
                      name     = "level",
                      dataType = "String",
                      example  = "INFO")
    private Level level;

    @JsonSerialize(using = MarkerSerializer.class)
    @JsonDeserialize(using = MarkerDeserializer.class)
    @ApiModelProperty(value    = "marker",
                      name     = "marker",
                      dataType = "String",
                      example  = "MARKER")
    private Marker marker;
    
    @ApiModelProperty(value    = "message",
                      name     = "message",
                      dataType = "String",
                      example  = "user message")
    private String message;
    
    @ApiModelProperty(value    = "params",
                      name     = "params")
    private Object[] params;
    
    @JsonDeserialize(using = LocalDateTimeDeserializerLOGGER.class)
    @JsonSerialize(using = LocalDateTimeSerializerLOGGER.class)
    @ApiModelProperty(value    = "Время",
                      name     = "date",
                      dataType = "String",
                      example  = "2022-06-02T11:36:37.932Z")
    private LocalDateTime date;

    public LogData() {
        
    }

    public LogData(Long id) {
        this.id = id;
    }
    

    public LogData(Long id, Level level, Marker marker, String message, Object[] params, LocalDateTime date) {
       //this.id = null == id ? /*сгенерировать уникальную id */ : id;
        this.id = id;
        this.level = level;
        this.marker = marker;
        this.message = message;
        this.params = params;
        this.date = date;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.level);
        hash = 17 * hash + Objects.hashCode(this.marker);
        hash = 17 * hash + Objects.hashCode(this.message);
        hash = 17 * hash + Arrays.deepHashCode(this.params);
        hash = 17 * hash + Objects.hashCode(this.date);
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
        if (!Objects.equals(this.id, other.id)) {
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

    @Override
    public String toString() {
        return "LogData{" + "id=" + id + ", level=" + level + ", marker=" + marker + ", message=" + message + ", params=" + Arrays.toString(params) + ", date=" + date + '}';
    }
}
