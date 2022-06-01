package com.itrail.test.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value    = "Ид лога", 
                      name     = "id", 
                      dataType = "Long", 
                      example  = "1", 
                      required = true)
    private Long id;
    
    @Column(name = "date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty(value    = "дата", 
                      name     = "date", 
                      dataType = "String", 
                      example  = "2022.04.12 11:02:42", 
                      required = false)
    private LocalDateTime date;
    
    @Column(name = "Levels")
    @ApiModelProperty(value = "Уровень лога",
                      name  = "levels",
                      dataType = "String",
                      example = "error",
                      required = false)
    private String levels;
    
    @Column(name = "Messages", length = 20000)
    @ApiModelProperty(value    = "сообщение", 
                      name     = "messages", 
                      dataType = "String", 
                      example  = "message", 
                      required = false)
    private String messages;
    
    @Column(name = "StackTrace", length = 20000)
    @ApiModelProperty(required = false)
    private String stackTrace;
    
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
                setMessages(wrappedEvent.getMessage().toString());
            }
            if(wrappedEvent.getLevel()!=null){
                setLevel(wrappedEvent.getLevel().toString());
            }
            
            if(wrappedEvent.getMarker() != null){             
                setMarker(wrappedEvent.getMarker().getName());      
            }
                //setstacktrace(wrappedEvent.getContextStack().toArray().toString()); //one element 
//                StackTraceElement[] stack = Thread.currentThread().getStackTrace();
//                setstacktrace( Arrays.stream(stack).map(StackTraceElement::toString).collect(Collectors.joining("\n")));   
        }
    }

    public LogView(LogEvent wrappedEvent, Long id, LocalDateTime date, String levels, String messages, String stackTrace, String marker) {
        this.wrappedEvent = wrappedEvent;
        this.id = id;
        this.date = date;
        this.levels = levels;
        this.messages = messages;
        this.stackTrace = stackTrace;
        this.marker = marker;
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

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getmarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.wrappedEvent);
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.date);
        hash = 43 * hash + Objects.hashCode(this.levels);
        hash = 43 * hash + Objects.hashCode(this.messages);
        hash = 43 * hash + Objects.hashCode(this.stackTrace);
        hash = 43 * hash + Objects.hashCode(this.marker);
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
        if (!Objects.equals(this.messages, other.messages)) {
            return false;
        }
        if (!Objects.equals(this.stackTrace, other.stackTrace)) {
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
        return Objects.equals(this.marker, other.marker);
    }

    @Override
    public String toString() {
        return "LogView{" + "wrappedEvent=" + wrappedEvent + ", id=" + id + ", date=" + date + ", levels=" + levels + ", messages=" + messages + ", stackTrace=" + stackTrace + ", marker=" + marker + '}';
    }

    

}