package com.meeting.wu.service.impl;

import com.meeting.wu.entity.User;
import com.meeting.wu.mapper.UserMapper;
import com.meeting.wu.service.LoginService;
import com.meeting.wu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result login(Long userId,String password){
        User user = userMapper.selectUser(userId);
        if(user==null){
            return new Result(502,"不存在该用户");
        }
        if(!user.getUserPassword().equals(password)){
            return new Result(503,"密码错误");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("userName",user.getUserName());
        map.put("userEamil",user.getUserEmail());
        return new Result(200,map);
    }

    @Override
    public Result changePassword(Long userId, String password) {
        int i = userMapper.changeUserPassword(userId, password);
        if(i==0){
            return new Result(504,"修改密码失败");
        }
        return new Result(200,"修改密码成功");
    }


}
