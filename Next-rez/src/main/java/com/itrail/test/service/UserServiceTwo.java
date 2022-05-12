
package com.itrail.test.service;

import com.itrail.test.domain.User;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author barysevich_k
 */

@Stateless
public class UserServiceTwo {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostConstruct
    protected void init(){ 
    }
 
    @PreDestroy
    protected void destroy(){   
    }
    
    public User getUs(Integer idUser){
        return entityManager.find(User.class, idUser);
    }
    
    public List<User> getAllUser(){
        return entityManager.createQuery("SELECT e FROM User e").getResultList();     
    }
    
    public void saveUser(User user){
        entityManager.persist(user);
    }
     
    public void createUsers(User...us2){
       createUsers( Arrays.asList(us2 ) );
    }
    
    @Transactional
    public void createUsers(List<User> us2){
        us2.stream().forEach( u -> entityManager.merge(u));
    }
    
    public void createUser(User us2){
        entityManager.merge(us2);
    }
    
    public void updateUser(Integer idUser, String name){
        User u = entityManager.find(User.class, idUser);
        u.setName(Objects.requireNonNull(name, "Name cannot be null"));
        entityManager.merge(u);
    }
  
    public void deleteUser(Integer idUser){
        User u = entityManager.find(User.class, idUser);
        entityManager.remove(u);
      //entityManager.createNativeQuery("delete from USERREST u where u.user_id = ?1").setParameter(1, idUser).executeUpdate(); //через SQL 
      //entityManager.createQuery("delete from User u where u.idUser = ?1").setParameter(1, idUser).executeUpdate();   //через JPQL
    }
}
