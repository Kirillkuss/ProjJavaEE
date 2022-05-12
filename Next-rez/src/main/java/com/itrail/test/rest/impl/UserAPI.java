
package com.itrail.test.rest.impl;

import com.itrail.test.domain.User;
import com.itrail.test.rest.UserResource;
import com.itrail.test.service.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("user")
public class UserAPI implements UserResource{

    @EJB private UserService service;
    
    @Override
    public List<User> getUserList() {
     
  
        System.out.println("Find ListUser>>>");
        System.out.println(service.getUsers());    
        return service.getUsers();
    }

    @Override
    
    public User getUserById(Integer id) {
        System.out.println("Find Users>>>");
        return service.findUser(id);
    }

    @Override
    public User setUserName(Integer id, String name) {
        System.out.println("Update User>>>");
        User user = service.findUser(id);
        if(null!= user){
            user.setName(name);
        }
        return user;
    }

    @Override
    public User updateUser(Integer id, User user) {  
        
        System.out.println("AddUser>>>");
       service.delUser(id);
       service.putUsers(user);
   
       return user;
    } 
   

    @Override
    public void createUser(User user) {
       service.putUsers(user);
     
    }

    @Override
    public void deleteUser(Integer id) {
        System.out.println("DeleteUser>>>");
        service.delUser(id);
   
    }


    
}

