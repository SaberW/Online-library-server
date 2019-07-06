package com.jeanswest.onlinelibrary.service;

import com.alibaba.fastjson.JSONObject;
import com.jeanswest.onlinelibrary.entity.ResultData;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import com.jeanswest.onlinelibrary.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

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

    public ResultData login(String username, String password, HttpServletRequest request) {
        UserDTO userDTO = userMapper.login(username, password);

        if (null != userDTO) {
            String userUUID = userDTO.getId() + "-" + UUID.randomUUID().toString();
            request.getSession().setAttribute(userUUID, userDTO);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Authorization", userUUID);
            jsonObject.put("username", userDTO.getUsername());
            jsonObject.put("userid", userDTO.getId());
            return ResultData.success("请求成功", jsonObject);
        } else {
            return ResultData.warn("警告", "账号或密码错误");
        }
    }

    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }
}
