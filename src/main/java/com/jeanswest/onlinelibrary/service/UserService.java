package com.jeanswest.onlinelibrary.service;

import com.jeanswest.onlinelibrary.mapper.UserDao;
import com.jeanswest.onlinelibrary.entity.LoginVO;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-10 14:28
 * @description : 用户相关业务
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserDTO> getUsers() {
        return userDao.listUser();
    }

    public UserDTO getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public Object saveUser(UserDTO user) {
       return userDao.saveUser(user);
    }

    public Object delUserById(Integer id) {
        return userDao.deleteById(id);
    }

    public Object putUserById(UserDTO user) {
       return userDao.updateUserById(user);
    }

    public Integer login(LoginVO loginVO){
        return userDao.login(loginVO);
    }
}
