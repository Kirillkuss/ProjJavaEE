
package com.itrail.test.app.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itrail.test.app.core.LocalDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(value    = "Время",
                      name     = "dateFrom",
                      dataType = "String",
                      example  = "12.05.2022 11:02:42")
    private LocalDateTime dateFrom;
    
    @Column(name="dateTo")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(value    = "Время",
                      name     = "dateTo",
                      dataType = "String",
                      example  = "12.06.2022 11:02:42")
    private LocalDateTime dateTo;
    
    @Column(name="limite")
    @ApiModelProperty(value="Количество", name ="limit", dataType="Integer", example = "100")
    private Integer limit;
    
    @Column(name="offsete")
    @ApiModelProperty(value="Начало", name="offset", dataType="Integer",example="12")
    private Integer offset;
    ;

    public FilterLog() {
        
    }

    public FilterLog(Long id, LocalDateTime dateFrom, LocalDateTime dateTo, Integer limit, Integer offset) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.limit = limit;
        this.offset = offset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dateFrom);
        hash = 97 * hash + Objects.hashCode(this.dateTo);
        hash = 97 * hash + Objects.hashCode(this.limit);
        hash = 97 * hash + Objects.hashCode(this.offset);
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
        return Objects.equals(this.offset, other.offset);
    }

    @Override
    public String toString() {
        return "FilterLog{" + "id=" + id + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", limit=" + limit + ", offset=" + offset + '}';
    }

}
