package com.jeanswest.onlinelibrary.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :肖钊容
 * @date :2019-06-26 18:44
 * @description :登录映射
 */
@Data
@ApiModel("登录界面映射")
public class LoginVO {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
