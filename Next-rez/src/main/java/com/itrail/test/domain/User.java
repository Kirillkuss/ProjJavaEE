package com.itrail.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author barysevich_k
 */
@Entity
@Table(name = "USERREST")
@ApiModel(description = "Информация о пользователе")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    @ApiModelProperty(value     = "Ид пользователя",
                      name      = "idUser",
                      dataType  = "Integer",
                      example   = "100",
                      required  = true)
    private Integer idUser;
    
    @NotEmpty(message = "Name User not be Empty")
    @Column(name = "name_user")
    @Size(min = 1, max = 20)
    @ApiModelProperty(value     = "Имя пользователя",
                      name      = "name",
                      dataType  = "String",
                      example   = "David",
                      required  = true )
    private String name;
    
    @Email(message = "Login has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    @Column(name = "login_user")
    @ApiModelProperty(value     = "Логин пользователя",
                      name      = "login",
                      dataType  = "String",
                      example   = "david@com.by",
                      required  = true)
    private String login;
    
    @Size(min = 9, max = 13)
    @Column(name = "phone_user")
    @ApiModelProperty(value    = "Номер телефона",
                      name     = "phone",
                      dataType = "String",
                      example  = "+375333453345",
                      required = false)
    private String phone;
    
    
    @Column(name = "wallet_user", length = 12)
    @ApiModelProperty(value    = "Кошелек пользователя ",
                      name     = "wallet",
                      dataType = "String",
                      example  = "1000.0",
                      required = true)
    private BigDecimal wallet;
    
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ANIMAL", joinColumns = @JoinColumn(name = "USER_ID"),
                              inverseJoinColumns = @JoinColumn(name = "ANIMAL_ID"))
    @ApiModelProperty(value    = "Питомцы пользователя ",
                      name     = "animal",
                      example  = "null",
                      required = false)
    private List<Animal> animal;

    public User() {

    }

    public User(Integer idUser, @NotEmpty String name, String login, String phone, BigDecimal wallet) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.phone = phone;
        this.wallet = wallet;
    }

    public User(Integer idUser, String name, String login, String phone, BigDecimal wallet, List<Animal> animal) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.phone = phone;
        this.wallet = wallet;
        this.animal = animal;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPhone() {
        return phone;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idUser);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.phone);
        hash = 53 * hash + Objects.hashCode(this.wallet);
        hash = 53 * hash + Objects.hashCode(this.animal);
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.wallet, other.wallet)) {
            return false;
        }
        return Objects.equals(this.animal, other.animal);
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", name=" + name + ", login=" + login + ", phone=" + phone + ", wallet=" + wallet + ", animal=" + animal + '}';
    }

}
