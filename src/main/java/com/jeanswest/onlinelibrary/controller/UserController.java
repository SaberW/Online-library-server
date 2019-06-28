package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.entity.LoginVO;
import com.jeanswest.onlinelibrary.entity.ResultData;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import com.jeanswest.onlinelibrary.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :肖钊容
 * @date :2019-06-11 10:27
 * @description :用户相关接口
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags = {"用户相关操作"})
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ResultData resultData;

    @GetMapping("users")
    public Object getUsers() {
        return userService.getUsers();
    }

    @GetMapping("user/{id}")
    public Object getUserById(@ApiParam("用户Id") @PathVariable(value = "id", required = true )Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("user")
    public Object saveUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("user/{id}")
    public Object delUserById(@ApiParam("用户Id") @PathVariable(value = "id", required = true) Integer id) {
        return userService.delUserById(id);
    }

    @PutMapping("user")
    public Object putUserById(@RequestBody UserDTO user) {
        return userService.putUserById(user);
    }    

    @PostMapping("login")
    public ResultData login(@RequestBody LoginVO loginVO){
        Integer userCount = userService.login(loginVO);
        resultData.setData(userCount);
        return resultData;
    }
}
