package com.xzr.onlinelibrary.mapper;

import com.xzr.onlinelibrary.entity.DownloadRecord;
import com.xzr.onlinelibrary.entity.User;

import java.util.List;

/**
 * @author :肖钊容
 * @version :1.0.0
 * @date :2019/8/29
 * @description :用户相关Mapper
 */
public interface UserMapper {
    public List<User> getUsers();

    /**
     * 获取用户下载记录
     * @param userId
     * @return
     */
    public User getUserDownloadRecord(Integer userId);

    User getUserById(Integer userId);
}

