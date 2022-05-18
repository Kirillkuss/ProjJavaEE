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
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.annotations.Type;

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
    
    @Column(name = "Messages", length = 14000)
    @ApiModelProperty(value    = "сообщение", 
                      name     = "messages", 
                      dataType = "String", 
                      example  = "message", 
                      required = false)
    private String messages;
    @Column(name = "StackTrace")
    @Type(type = "text")
    @ApiModelProperty(required = false)
    private String stackTrace;
    
 
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
                setLevels(wrappedEvent.getLevel().toString());
            }
            if(wrappedEvent.getThrown()!=null){
              
              setstacktrace(ExceptionUtils.getStackTrace(wrappedEvent.getThrown())); 
            }
           //setstacktrace(Arrays.toString(wrappedEvent.getThrown().getStackTrace()));
           //setstacktrace(wrappedEvent.getThrown().getStackTrace().toString());
           //setstacktrace(wrappedEvent.getLevel().toString());
        }
        
    }

    public String getstacktrace() {
        return stackTrace;
    }

    public void setstacktrace(String stackTrace) {
       
        this.stackTrace = stackTrace;
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

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getmessage() {
        return messages;
    }

    public void setMessages(String message) {
        this.messages = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.wrappedEvent);
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.levels);
        hash = 89 * hash + Objects.hashCode(this.messages);
        hash = 89 * hash + Objects.hashCode(this.stackTrace);
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
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "LogView{" + "wrappedEvent=" + wrappedEvent + ", id=" + id + ", date=" + date + ", levels=" + levels + ", messages=" + messages + ", stackTrace=" + stackTrace + '}';
    }

  
    

}