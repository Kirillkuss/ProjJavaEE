
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
    @ApiModelProperty(value = "Ид лога", name="id", dataType="Long", example = "1")
    private Long id;
    
    @Column(name="date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @ApiModelProperty(value = "Время", name="date",dataType="String", example = "12.04.2022 11:02:42")
    private LocalDateTime date;

    public FilterLog() {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.date);
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
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "FilterLog{" + "id=" + id + ", date=" + date + '}';
    }
     


    
    
}
