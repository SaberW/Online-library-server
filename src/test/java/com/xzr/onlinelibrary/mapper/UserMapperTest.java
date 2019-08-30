package com.xzr.onlinelibrary.mapper;


import com.xzr.onlinelibrary.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getUsersTest() {
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserDownloadRecord() {
        User user = userMapper.getUserDownloadRecord(1);
        System.out.println(user);
    }

    @Test
    public void getUserByIdTest(){
        User user1 = userMapper.getUserById(1);
        User user2 = userMapper.getUserById(1);
    }

}