package com.meeting.wu.entity;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */

/**
 * 用户实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long userId;
    String userName;
    String userPassword;
    String userEmail;
}
