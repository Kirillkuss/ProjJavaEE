
package com.itrail.test;
import com.itrail.test.app.model.LogView;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.User;
import com.itrail.test.service.AnimalServiceTwo;
import com.itrail.test.service.BuyService;
import com.itrail.test.service.LogService;
import com.itrail.test.service.UserServiceTwo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
/**
 *
 * @author barysevich_k
 */
@Singleton
@Startup
public class ApplicationTest  {
    @EJB private UserServiceTwo service;
    @EJB private AnimalServiceTwo service2;
    @EJB private BuyService service3;
    @EJB private LogService service4;

    @PostConstruct
    public void init(){
        service.createUsers(
                new User(null,"Petr","ppp@mail.ru","+3752508878",new BigDecimal("10000.23")),
                new User(null, "Robert", "rrrrr@ty.ru", "+37529894545", new BigDecimal("5000.34")),
                new User(null, "Misha", "mmmm@ven.by", "+3751224892", new BigDecimal("20000.45") ),
                new User(null,"Andrei","aaaaa@list.com", "+37533783434",new BigDecimal("900.54")));  
        service2.createAnimal(new Animal(null,"cat",new BigDecimal("600.23"),2),
                              new Animal(null,"dog",new BigDecimal("400.21"),1),
                              new Animal(null,"bird",new BigDecimal("400.256"),34),
                              new Animal(null,"turtle",new BigDecimal("800.46"),5),
                              new Animal(null,"snake",new BigDecimal("300.87"),5)); 
        service3.createOrder();    
        service4.createLog();
    }

    @PreDestroy
    public void destroy(){
        
    }
       
}
