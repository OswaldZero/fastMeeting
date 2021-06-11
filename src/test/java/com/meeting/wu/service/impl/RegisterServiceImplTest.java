package com.meeting.wu.service.impl;

import com.meeting.wu.WuApplication;
import com.meeting.wu.entity.User;
import com.meeting.wu.mapper.UserMapper;
import com.meeting.wu.service.RegisterService;
import com.meeting.wu.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WuApplication.class)
class RegisterServiceImplTest {
    @Autowired
    public UserMapper userMapper;

    @Test
    void insert() {
        User user = new User(111L, "wu", "wrt", "17269036835@qq.com");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }
    @Test
    void change(){
        userMapper.changeUserPassword(111L,"222");
    }

    @Test
    void setUserMapper(){
        System.out.println(userMapper.selectUser(111L));
    }
}