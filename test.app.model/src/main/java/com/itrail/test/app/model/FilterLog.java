
package com.itrail.test.app.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itrail.test.app.core.InstantDeserializer;
import com.itrail.test.app.core.LocalDateTimeDeserializerLOGGER;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.logging.log4j.Level;
/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name="FilterLog")
@ApiModel(description = "Запрос по логгам")
public class FilterLog implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value    = "Ид лога",
                      name     = "id",
                      dataType = "Long",
                      example  = "1")
    private Long id;
    
    @Column(name="dateFrom")
    @JsonDeserialize(using = InstantDeserializer.class)
    @ApiModelProperty(value    = "Время c ",
                      name     = "dateFrom",
                      dataType = "String",
                      example  = "2022-05-03T11:36:37.932Z")
    private Instant dateFrom;
    
    @Column(name="dateTo")
    @JsonDeserialize(using = InstantDeserializer.class)
    @ApiModelProperty(value    = "Время до",
                      name     = "dateTo",
                      dataType = "String",
                      example  = "2022-08-03T11:36:37.932Z")
    private Instant dateTo;
    
    @Column(name="limite")
    @ApiModelProperty(value    = "Количество",
                      name     = "limit",
                      dataType = "Integer",
                      example  = "100")
    private Integer limit;
    
    @Column(name="offsete")
    @ApiModelProperty(value    = "Начало",
                      name     = "offset",
                      dataType = "Integer",
                      example  = "12")
    private Integer offset;
    
    @Column(name="level")
    @ApiModelProperty(value    = "Статус",
                      name     = "level",
                      dataType = "String",
                      example  = "INFO")
    private Level level;
    
    public FilterLog() {
    }

    public FilterLog(Long id, Instant dateFrom, Instant dateTo, Integer limit, Integer offset, Level level) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.limit = limit;
        this.offset = offset;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Instant dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Instant getDateTo() {
        return dateTo;
    }

    public void setDateTo(Instant dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getLimit() {
        if(limit == null){limit = 1000;}
        if(limit < 0){limit = 1000;}
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        if(offset == null) {offset = 0;}
        if(offset < 0) {offset = 0;}
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Level getlevel() {
        return level;
    }

    public void setlevel(Level level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.dateFrom);
        hash = 13 * hash + Objects.hashCode(this.dateTo);
        hash = 13 * hash + Objects.hashCode(this.limit);
        hash = 13 * hash + Objects.hashCode(this.offset);
        hash = 13 * hash + Objects.hashCode(this.level);
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
        final FilterLog other = (FilterLog) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateFrom, other.dateFrom)) {
            return false;
        }
        if (!Objects.equals(this.dateTo, other.dateTo)) {
            return false;
        }
        if (!Objects.equals(this.limit, other.limit)) {
            return false;
        }
        if (!Objects.equals(this.offset, other.offset)) {
            return false;
        }
        return Objects.equals(this.level, other.level);
    }

    @Override
    public String toString() {
        return "FilterLog{" + "id=" + id + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", limit=" + limit + ", offset=" + offset + ", level=" + level + '}';
    }
      

    
}
