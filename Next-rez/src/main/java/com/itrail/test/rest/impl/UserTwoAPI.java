
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.User;
import com.itrail.test.rest.UserResourceTwo;
import com.itrail.test.service.UserServiceTwo;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("entitymanager")
public class UserTwoAPI implements UserResourceTwo {
    
    @EJB private UserServiceTwo service;
    @Override
    public BaseResponse getAllUsers() {
        BaseResponse bs = new BaseResponse(200,"success");
        List<User> rezult =  service.getAllUser();
        bs.setData(rezult);
        return bs;
    }
    
    @Override
    public BaseResponse getUserByID(Integer idUser) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getUs(idUser));
        return bs;
    }
    
    @Override
    public BaseResponse createUser(User user) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData("Create User:" + user);
        service.createUser(user);
        return bs;
    }

    @Override
    public BaseResponse deleteUserUM(Integer idUser){
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData("Delete User: " + idUser);
        service.deleteUser(idUser);
        return bs;
    }

    @Override
    public BaseResponse updateUser(Integer idUser, String name) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData("IdUser: "+ idUser +" Name: " + name);
        service.updateUser(idUser, name);
        return bs;
    }  
 
}
