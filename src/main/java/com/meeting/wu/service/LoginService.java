package com.meeting.wu.service;

import com.meeting.wu.entity.User;
import com.meeting.wu.utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
public interface LoginService {
    public Result login(Long userId,String password);
    public Result changePassword(Long userId,String password);
}
