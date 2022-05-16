package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.app.core.LocalDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Доменный класс для описания сущности заказ
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "ORDEREST")
@ApiModel(description = "Информация о заказе")
public class Order implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value    = "Ид заказa", 
                      name     = "IdOrder", 
                      dataType = "Integer", 
                      example  = "1", 
                      required = false)
    private Integer idOrder;
    
    @ApiModelProperty(value    = "Ид покупателя",
                      name     = "userID",
                      dataType = "Integer",
                      example  = "1",
                      required = false)
    private Integer userID;
    
    @ApiModelProperty(value    = "Ид питомца",
                      name     = "animalID",
                      dataType = "Integer",
                      example  = "1",
                      required = false)
    private Integer animalID;
    
    @ApiModelProperty(value    = "Стоипость покупки",
                      name     = "sum",
                      dataType = "String",
                      example  = "400.2",
                      required = false)
    private BigDecimal sum;
    
    
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty(value    = "Время покупки",
                      name     = "time",
                      dataType = "String",
                      example  = "12.04.2022 11:02:42",
                      required = false)
    private LocalDateTime time;

    public Order() {
    }

    /**
     * Order constructor
     *
     * @param idOrder - ИД заказа
     * @param userID - ИД покупателя
     * @param animalID - ИД питомца
     * @param sum - стоимость покупки
     * @param time - время и дата покупки
     */
    public Order(Integer idOrder, Integer userID, Integer animalID, BigDecimal sum, LocalDateTime time) {
        this.idOrder = idOrder;
        this.userID = userID;
        this.animalID = animalID;
        this.sum = sum;
        this.time = time;
    }

    /**
     * Gets the idOrder code
     *
     * @return <code> Integer </code> specifying the idOrder code
     */

    public Integer getIdOrder() {
        return idOrder;
    }

    /**
     * Sets the idOrder code
     *
     * @param idOrder the idOrder code
     */

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * Gets the userID code
     *
     * @return <code> Integer </code> specifying the userID code
     */

    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the userID code
     *
     * @param userID the userId code
     */

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Gets the animalID
     *
     * @return <code> Integer </code> srecifying the animalID code
     */

    public Integer getAnimalID() {
        return animalID;
    }

    /**
     * Sets the animalID code
     *
     * @param animalID the animalID code
     */

    public void setAnimalID(Integer animalID) {
        this.animalID = animalID;
    }

    /**
     * Gets the sum code
     *
     * @return <code> BigDecimal </code> specifying the sum code
     */

    public BigDecimal getSum() {
        return sum;
    }

    /**
     * Sets the sum code
     *
     * @param sum the sum code
     */

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    /**
     * Gets the time code
     *
     * @return <code> LocalDateTime </code> specifying the time code
     */

    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Sets the time code
     *
     * @param time the time code
     */

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Этот метод предназначен для определения примерного расположения объекта в
     * хэш-таблице с целью увелечения скорости поиска объекта
     *
     * @return <code> int </code>
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idOrder);
        hash = 67 * hash + Objects.hashCode(this.userID);
        hash = 67 * hash + Objects.hashCode(this.animalID);
        hash = 67 * hash + Objects.hashCode(this.sum);
        hash = 67 * hash + Objects.hashCode(this.time);
        return hash;
    }

    /**
     * Этот метод предназначен для сравнения двух объектов
     *
     * @param obj - объект
     * @return  <code> boolean </code>
     */

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
        final Order other = (Order) obj;
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        if (!Objects.equals(this.animalID, other.animalID)) {
            return false;
        }
        return Objects.equals(this.sum, other.sum);
    }

    /**
     * Переводит в формат строки
     *
     * @return <code> String</code>
     *
     */

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", userID=" + userID + ", animalID=" + animalID + ", sum=" + sum + ", time=" + time + '}';
    }

}
