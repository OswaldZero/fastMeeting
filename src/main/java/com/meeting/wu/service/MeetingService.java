package com.meeting.wu.service;

import com.meeting.wu.entity.Meeting;
import com.meeting.wu.entity.Option;
import com.meeting.wu.utils.Result;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
public interface MeetingService {
    public Result createMeeting(Meeting meeting,Long userId);
    public Result selectMeeting(Option option);
    public Result selectMeetingByUserId(Long userId);
    public Result signUp(Integer meetingId,Long userId, BigDecimal longitude, BigDecimal latitude);
    public Result selectUserByMeetingId(Integer meetingId);
}
