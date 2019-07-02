package com.jeanswest.onlinelibrary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @author :肖钊容
 * @date :2019-06-08 23:55
 * @description :用户
 */
@Data
@ApiModel(value="用户模型")
@TableName("user")
public class UserDTO {
    @ApiModelProperty(value="id会自动生成 可不加",name="id",example="0")
    private Long id;

    @ApiModelProperty(value="用户密码",name="password",example="123")
    private String password;

    @ApiModelProperty(value="用户账号",name="username",example="user1")
    private String username;

    @ApiModelProperty(value="账号状态 0(已注销) 1(正常使用)",name="accountStatus",example="1")
    private Integer accountStatus;

    @ApiModelProperty(value="用户等级 root(最高权限) admin(普通管理员) user(普通用户)",name="grade",example="user")
    private String grade ;

    @ApiModelProperty(value="最后登录时间",name="lastLogin",example="2019-06-11 22:34:30")
    private String lastLogin;

    @ApiModelProperty(value="用户注册时间",name="registrationDate",example="2019-06-11 22:34:30")
    private String registrationDate;

    private List<DownloadRecordDTO> downloadRecords;
}
