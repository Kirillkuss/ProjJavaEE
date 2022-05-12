package com.itrail.test.app.model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import javax.persistence.Column;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.db.jpa.BasicLogEventEntity;
/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "LOGGERSTABLE")
@ApiModel(description = "Таблица логов") 
public class LogView extends BasicLogEventEntity  {
    private LogEvent wrappedEvent;

    @Column(name = "LOG_ID")
    @ApiModelProperty(value    = "Ид лога", 
                      name     = "IdLogger", 
                      dataType = "Integer", 
                      example  = "1", 
                    required = true)
    @Id
    private Long id;
    
    
    @Column(name = "date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty(value    = "дата", 
                      name     = "date", 
                      dataType = "String", 
                      example  = "12.04.2022 11:02:42", 
                      required = true)
    private LocalDateTime date;
    
    @Column(name = "text")
    @ApiModelProperty(value    = "сообщение", 
                      name     = "text", 
                      dataType = "String", 
                      example  = "message", 
                      required = true)
    private String text;

    public LogView() {
    }

    public LogView(LogEvent wrappedEvent) {
        super(wrappedEvent);
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

    public String getText() {
        return text;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
            hash = 13 * hash + Objects.hashCode(this.id);
            hash = 13 * hash + Objects.hashCode(this.date);
            hash = 13 * hash + Objects.hashCode(this.text);
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
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    
    @Override
    public String toString() {
        return "LogView{" + "id=" + id + ", date=" + date + ", text=" + text + '}';
    }
    
    
}