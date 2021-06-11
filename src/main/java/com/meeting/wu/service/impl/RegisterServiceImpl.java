package com.meeting.wu.service.impl;

import com.meeting.wu.entity.User;
import com.meeting.wu.mapper.UserMapper;
import com.meeting.wu.service.RegisterService;
import com.meeting.wu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result register(User user) {
        User u = userMapper.selectUser(user.getUserId());
        if (u!=null){
            return new Result(501,"用户id已存在");
        }
        int i = userMapper.insertUser(user);
        if(i==0){
            return new Result(500,"创建用户失败");
        }
        return new Result(200,"创建用户成功");
    }
}
