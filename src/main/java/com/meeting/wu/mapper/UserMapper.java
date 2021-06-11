package com.meeting.wu.mapper;

import com.meeting.wu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Repository
@Mapper
public interface UserMapper {
    public int insertUser(User user);
    public int changeUserPassword(@Param("userId") Long userId, @Param("userPassword") String userPassword);
    public User selectUser(@Param("userId") Long userId);
}
