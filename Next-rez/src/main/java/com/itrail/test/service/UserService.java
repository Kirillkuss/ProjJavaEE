package com.itrail.test.service;

import com.itrail.test.domain.Animal;
import com.itrail.test.domain.User;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
/**
 *
 * @author barysevich_k
 */
@Stateless
public class UserService {
    
   List<Animal> listAnimals = new LinkedList<>(Arrays.asList(new Animal(1,"cat",new BigDecimal("100.23"),2),
                                                     new Animal(5,"dog", new BigDecimal("50.21"),1),
                                                     new Animal(20,"bird", new BigDecimal("150.25677"),2),
                                                     new Animal(24,"turtle", new BigDecimal("200.4686"),2),
                                                     new Animal(40,"snake", new BigDecimal("300.8789"),3)));
   
      List<Animal> listAnimalss = new LinkedList<>(Arrays.asList(new Animal(1,"cat",new BigDecimal("100.23"),2),
                                                                 new Animal(5,"dog", new BigDecimal("50.21"),1)));
    
    List<User> us2 = new LinkedList<>(Arrays.asList(new User(1,"Petr","ppp","+3752508878", new BigDecimal("300.45"), listAnimals),
                                                    new User(5,"Andrei","aaaaa", "+37533783434",new BigDecimal("500.23"), listAnimals),
                                                    new User(10, "Misha", "mmmm", "+3751224892",new BigDecimal("800.34"), listAnimalss )));
    
    public List<User> getUsers(){
        return us2;
    }
    
    public boolean putUsers(User user){
        return us2.add(user);
        
    }
    
    public User findUser(Integer idUser){
        return us2.stream()
                  .filter(s-> Objects.equals(s.getIdUser(),idUser))
                  .findFirst()
                  .orElse(null);
    }
   
    public boolean delUser(Integer idUser){
       return us2.removeIf(s-> Objects.equals(s.getIdUser(), idUser));
    }
    
    public boolean modify(Integer idUser, String name){
        Optional<User> us1 = us2.stream()
                                .filter(s->Objects.equals(s.getIdUser(),idUser))
                                .findAny();
        if(us1.isPresent()) us1.get().setName(name);
        
        return us1.isPresent();
    }
}
