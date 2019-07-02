package com.jeanswest.onlinelibrary.service;

import com.jeanswest.onlinelibrary.entity.UserDTO;
import com.jeanswest.onlinelibrary.mapper.UserMapper;
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
    private UserMapper userMapper;

    public List<UserDTO> getUsers() {
        return userMapper.listUser();
    }

    public UserDTO getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public Object saveUser(UserDTO user) {
       return userMapper.saveUser(user);
    }

    public Object delUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    public Object putUserById(UserDTO user) {
       return userMapper.updateUserById(user);
    }

    public Integer login(UserDTO userDTO){
        return userMapper.login(userDTO);
    }

    public List<UserDTO> findAll(){
        return userMapper.findAll();
    }
}
