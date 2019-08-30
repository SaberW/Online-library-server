package com.xzr.onlinelibrary.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * @author :xzr
 * @date :2019-08-27 11:14
 * @description :
 */

/**
 * @Alias("u") 可在包扫描出现 同样类名的情况下 起一个另外的别名
 */
@Data
public class User {
    private Integer uId;

    private String password;

    private String username;

    private Integer accountStatus;

    private String grade;

    private Date lastLogin;

    private Date registrationDate;

    private List<DownloadRecord> userDownloadRecord;
}
