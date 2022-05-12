package com.itrail.test.service;

import com.itrail.test.domain.User;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.ejb.Stateless;
/**
 *
 * @author barysevich_k
 */
@Stateless
public class UserService {
    
    List<User> us2 = new LinkedList<>(Arrays.asList(new User(1,"Petr","ppp","+3752508878", new BigDecimal("300.45")),
                                                    new User(5,"Andrei","aaaaa", "+37533783434",new BigDecimal("500.23")),
                                                    new User(10, "Misha", "mmmm", "+3751224892",new BigDecimal("800.34"))));
    
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
