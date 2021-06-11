package com.meeting.wu.mapper;

import com.meeting.wu.entity.Relationship;
import org.apache.ibatis.annotations.Insert;
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
public interface RelationshipMapper {
    int insertRelationship(@Param("userId") Long userId,@Param("meetingId") Integer meetingId,@Param("status") Integer status);
    Relationship selectRelationship(@Param("meetingId") Integer meetingId,@Param("userId") Long userId);
}
