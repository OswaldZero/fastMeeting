package com.meeting.wu.mapper;

import com.meeting.wu.entity.Meeting;
import com.meeting.wu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Repository
@Mapper
public interface MeetingMapper {
    public int insertMeeting(Meeting meeting);
    public List<Meeting> selectMeetingByTime(@Param("timeBegin") LocalDateTime timeBegin,@Param("timeEnd") LocalDateTime timeEnd,@Param("meetingName") String meetingName,@Param("startRecord")Integer startRecord,@Param("offsets")Integer offsets);
    public List<Meeting> selectMeetingByUserId(@Param("userId") Long userId);
    public Meeting selectMeetingByMeetingId(@Param("meetingId") Integer meetingId);
    public List<User> selectUserByMeetingId(@Param("meetingId") Integer meetingId,@Param("status") Integer status);
}
