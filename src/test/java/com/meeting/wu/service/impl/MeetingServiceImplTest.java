package com.meeting.wu.service.impl;

import com.meeting.wu.WuApplication;
import com.meeting.wu.entity.Meeting;
import com.meeting.wu.mapper.MeetingMapper;
import com.meeting.wu.service.MeetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = WuApplication.class)
class MeetingServiceImplTest {
    @Autowired
    public MeetingService meetingService;

    @Autowired
    public MeetingMapper meetingMapper;

    @Test
    void createMeeting(){
        Meeting meeting = new Meeting();
        meeting.setMeetingName("小老虎");
        meeting.setMeetingDescription("小老虎的会议");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime begin = LocalDateTime.parse("2021-06-06 10:00:24", df);
        LocalDateTime end = LocalDateTime.parse("2021-06-06 14:00:24", df);
        meeting.setTimeBegin(begin);
        meeting.setTimeEnd(end);
        meetingService.createMeeting(meeting,111L);
    }

    @Test
    void testCreateMeeting() {
        meetingService.signUp(3,20183L,new BigDecimal(123),new BigDecimal(122));
    }

    @Test
    void testCreateMeeting1() {
        Meeting meeting = meetingMapper.selectMeetingByMeetingId(2);
        System.out.println(meeting);
    }
}