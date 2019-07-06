package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.entity.ResultData;
import com.jeanswest.onlinelibrary.entity.UserDTO;
import com.jeanswest.onlinelibrary.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :肖钊容
 * @date :2019-06-11 10:27
 * @description :用户相关接口
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/user/")
@Api(tags = {"用户相关操作"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public Object getUsers() {
        try {
            return ResultData.success("请求成功", userService.getUsers());
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Object getUserById(@ApiParam("用户Id") @PathVariable(value = "id", required = true) Integer id) {

        try {
            return ResultData.success("请求成功", userService.getUserById(id));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @PostMapping("user")
    public Object saveUser(@RequestBody UserDTO user) {
        try {
            return ResultData.success("请求成功", userService.saveUser(user));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public Object delUserById(@ApiParam("用户Id") @PathVariable(value = "id", required = true) Integer id) {

        try {
            return ResultData.success("请求成功", userService.delUserById(id));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @PutMapping("user")
    public Object putUserById(@RequestBody UserDTO user) {
        try {
            return ResultData.success("请求成功", userService.putUserById(user));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("填写username 与password 登录成功返回用户ID")
    @PostMapping("login")
    public ResultData login(@RequestBody UserDTO userDTO ,HttpServletRequest request) {
        try {
            return  userService.login(userDTO.getUsername(), userDTO.getPassword(),request);
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @GetMapping("findAll")
    public Object findAll() {

        try {
            return ResultData.success("请求成功", userService.findAll());
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }
}
