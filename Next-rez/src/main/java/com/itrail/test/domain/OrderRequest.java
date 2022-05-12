
package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itrail.test.app.core.LocalDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author barysevich_k
 */
@ApiModel(description = "Поиск заказа по параметрам")
@Entity
@Table(name = "ORDERRQ")
public class OrderRequest implements Serializable {
    
    @ApiModelProperty(value = "Ид заказе", name = "idOrderRq", dataType = "Integer",example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderRq;
    
    @ApiModelProperty(value = "Ид пользователя", name = "idUser", dataType = "Integer", example = "1")
    private Integer idUser;
    
    @ApiModelProperty(value = "Время и Дата заказа", name = "time",dataType = "String", example = "08.04.2022 10:15:46")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class) 
    private LocalDateTime time;

    public OrderRequest() {
    }

    public OrderRequest(Integer idOrderRq, Integer idUser, LocalDateTime time) {
        this.idOrderRq = idOrderRq;
        this.idUser = idUser;
        this.time = time;
    }

    public Integer getIdOrderRq() {
        return idOrderRq;
    }

    public void setIdOrderRq(Integer idOrderRq) {
        this.idOrderRq = idOrderRq;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idOrderRq);
        hash = 59 * hash + Objects.hashCode(this.idUser);
        hash = 59 * hash + Objects.hashCode(this.time);
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
        final OrderRequest other = (OrderRequest) obj;
        if (!Objects.equals(this.idOrderRq, other.idOrderRq)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        return Objects.equals(this.time, other.time);
    }

    @Override
    public String toString() {
        return "OrderRq{" + "idOrderRq=" + idOrderRq + ", IdUser=" + idUser + ", time=" + time + '}';
    }
}
