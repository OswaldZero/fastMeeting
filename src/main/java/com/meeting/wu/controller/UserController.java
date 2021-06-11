package com.meeting.wu.controller;

import com.meeting.wu.entity.User;
import com.meeting.wu.service.LoginService;
import com.meeting.wu.service.RegisterService;
import com.meeting.wu.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@RestController
@Api("用户相关接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @ApiImplicitParam(name = "user",value = "用户实体",paramType = "body",dataType = "User")
    public Result register(@RequestBody User user){
        return registerService.register(user);
    }

    @GetMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType ="Long"),
            @ApiImplicitParam(name = "userPassword",value = "用户密码",paramType = "query",dataType = "String")
    })
    public Result login(@RequestParam("userId") Long userId,@RequestParam("userPassword") String userPassword){
        return loginService.login(userId,userPassword);
    }

    @PutMapping("/change")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType ="Long"),
            @ApiImplicitParam(name = "userPassword",value = "用户新密码",paramType = "query",dataType = "String")
    })
    public Result change(@RequestParam("userId") Long userId,@RequestParam("userPassword") String userPassword){
        return loginService.changePassword(userId,userPassword);
    }
}
