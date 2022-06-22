package com.itrail.test.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LocalDateTimeSerializerLOGGER;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.db.jpa.BasicLogEventEntity;
/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "LOGGERSTABLE")
@ApiModel(description = "Таблица логов")
@JsonInclude(Include.NON_DEFAULT)
public class LogView extends BasicLogEventEntity  {
    private LogEvent wrappedEvent;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value    = "Ид лога", 
                      name     = "id", 
                      dataType = "Long", 
                      example  = "1", 
                      required = true)
    private Long id;

//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//        name = "UUID",
//        strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", updatable = false, nullable = false)
//    private UUID id;
    
    @Column(name = "date")
    @JsonSerialize(using = LocalDateTimeSerializerLOGGER.class)
    @ApiModelProperty(value    = "дата", 
                      name     = "date", 
                      dataType = "String", 
                      example  = "2022-06-03T11:36:37.932Z", 
                      required = false)
    private LocalDateTime date;
    
    @Column(name = "Levels")
    @ApiModelProperty(value = "Уровень лога",
                      name  = "levels",
                      dataType = "String",
                      example = "error",
                      required = false)
    private String levels;
    
    @Column(name = "message", length = 20000)
    @ApiModelProperty(value    = "сообщение", 
                      name     = "message", 
                      dataType = "String", 
                      example  = "message", 
                      required = false)
    private String message;
    
    @Column(name = "Params")
    @ApiModelProperty(required = false)
    private Object[] params;
    
    @Column(name = "marker")
    @ApiModelProperty(required = false)
    private String marker;
    
    public LogView() {
    }
    
    public LogView(LogEvent wrappedEvent) {
        super(wrappedEvent);
        if(wrappedEvent != null){
            setDate(Instant.ofEpochMilli(wrappedEvent.getTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime());
            if(wrappedEvent.getMessage() != null){
                setmessage(wrappedEvent.getMessage().toString());
            }
            if(wrappedEvent.getLevel()!=null){
                setLevel(wrappedEvent.getLevel().toString());
            }
            
            if(wrappedEvent.getMarker() != null){             
                setmarker(wrappedEvent.getMarker().getName());      
            }
            if(wrappedEvent.getMessage().getParameters() !=null){
                setParams(wrappedEvent.getMessage().getParameters());
            }
                //setstacktrace(wrappedEvent.getContextStack().toArray().toString()); //one element 
//                StackTraceElement[] stack = Thread.currentThread().getStackTrace();
//                setstacktrace( Arrays.stream(stack).map(StackTraceElement::toString).collect(Collectors.joining("\n")));   
        }
    }

    public LogView( Long id, LocalDateTime date, String levels, String message,String marker, Object[] params) {
        this.id = id;
        this.date = date;
        this.levels = levels;
        this.message = message;
        this.params = params;
        this.marker = marker;
    }
    
    public LogView( Long id, LocalDateTime date, String levels, String message, Object[] params) {
        this.id = id;
        this.date = date;
        this.levels = levels;
        this.message = message;
        this.params = params;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getlevel() {
        return levels;
    }

    public void setLevel(String levels) {
        this.levels = levels;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getmarker() {
        return marker;
    }

    public void setmarker(String marker) {
        this.marker = marker;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.wrappedEvent);
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.levels);
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.params);
        hash = 67 * hash + Objects.hashCode(this.marker);
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
        final LogView other = (LogView) obj;
        if (!Objects.equals(this.levels, other.levels)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.marker, other.marker)) {
            return false;
        }
        if (!Objects.equals(this.wrappedEvent, other.wrappedEvent)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Arrays.deepEquals(this.params, other.params);
    }

    @Override
    public String toString() {
        return "LogView{" + "wrappedEvent=" + wrappedEvent + ", id=" + id + ", date=" + date + ", levels=" + levels + ", message=" + message + ", params=" + params + ", marker=" + marker + '}';
    }
    
}