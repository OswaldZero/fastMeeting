package com.meeting.wu.service.impl;

import com.meeting.wu.entity.Meeting;
import com.meeting.wu.entity.Option;
import com.meeting.wu.entity.Relationship;
import com.meeting.wu.entity.User;
import com.meeting.wu.mapper.MeetingMapper;
import com.meeting.wu.mapper.RelationshipMapper;
import com.meeting.wu.service.MailService;
import com.meeting.wu.service.MeetingService;
import com.meeting.wu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingMapper meetingMapper;
    @Autowired
    private RelationshipMapper relationshipMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result createMeeting(Meeting meeting,Long userId){
        LocalDateTime timeBegin = meeting.getTimeBegin();
        LocalDateTime timeEnd = meeting.getTimeEnd();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Meeting> meetings = meetingMapper.selectMeetingByTime(timeBegin, timeEnd, null, null, null);
        if(!meetings.isEmpty()){
            return new Result(507,"预定会议时间段冲突");
        }

        //预定会议
        int i = meetingMapper.insertMeeting(meeting);
        if(i==0){
            return new Result(508,"预定会议失败");
        }
        relationshipMapper.insertRelationship(userId,meeting.getMeetingId(),1);
        return new Result(200,"预定会议成功");
    }

    @Override
    public Result selectMeeting(Option option) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if(option.getTimeBegin()==null){
            option.setTimeBegin(LocalDateTime.parse("1970-01-01 00:00:00", df));
        }
        if(option.getTimeEnd()==null){
            option.setTimeEnd(LocalDateTime.parse("2100-01-01 00:00:00", df));
        }
        if(option.getMeetingName()==null){
            option.setMeetingName("");
        }
        List<Meeting> meetings = meetingMapper.selectMeetingByTime(option.getTimeBegin(), option.getTimeEnd(), option.getMeetingName(), (option.getPage() - 1) * option.getSize(), option.getSize());
        return new Result(200,meetings);
    }

    @Override
    public Result selectMeetingByUserId(Long userId) {
        List<Meeting> meetings = meetingMapper.selectMeetingByUserId(userId);
        return new Result(200,meetings);
    }

    @Override
    public Result signUp(Integer meetingId,Long userId, BigDecimal longitude, BigDecimal latitude) {
        Meeting meeting = meetingMapper.selectMeetingByMeetingId(meetingId);
        BigDecimal x=meeting.getLongitude().subtract(longitude).abs().pow(2);
        BigDecimal y=meeting.getLatitude().subtract(latitude).abs().pow(2);
        BigDecimal result = x.add(y);
        BigDecimal balance = meeting.getRadius().pow(2);
        if(balance.compareTo(result)==-1){
            return new Result(509,"不在会议范围内,签到失败");
        }
        LocalDateTime timeBegin = meeting.getTimeBegin();
        LocalDateTime timeEnd = meeting.getTimeEnd();
        LocalDateTime now = LocalDateTime.now();
        int positive = now.compareTo(timeBegin);
        int negative = now.compareTo(timeEnd);
        if(!(positive>0 && negative <0)){
            return new Result(510,"不在会议签到时间内");
        }
        Relationship relationship = relationshipMapper.selectRelationship(meetingId, userId);
        if(relationship==null){
            relationshipMapper.insertRelationship(userId,meetingId,0);
        }
        return new Result(200,"会议签到成功");
    }

    @Override
    public Result selectUserByMeetingId(Integer meetingId) {
        List<User> user1 = meetingMapper.selectUserByMeetingId(meetingId,1);
        List<User> user2 = meetingMapper.selectUserByMeetingId(meetingId, 0);
        List<User> user3 = new LinkedList<>(user1);
        for (User user : user2) {
            user3.add(user);
        }
        return new Result(200,user3);
    }
}
