package com.meeting.wu.mapper;

import com.meeting.wu.WuApplication;
import com.meeting.wu.entity.Meeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = WuApplication.class)
class MeetingMapperTest {
    @Autowired
    public MeetingMapper meetingMapper;
    @Test
    void insertMeeting() {
        Meeting meeting = new Meeting();
        meeting.setMeetingName("第一次会议");
        meeting.setMeetingDescription("党团学青的会议");
        meeting.setTimeBegin(LocalDateTime.now());
        meeting.setTimeEnd(LocalDateTime.now());
        meetingMapper.insertMeeting(meeting);
    }

    @Test
    void testInsertMeeting() {
        Meeting meeting = new Meeting();
        meeting.setMeetingName("第一次会议");
        meeting.setMeetingDescription("党团学青的会议");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime begin = LocalDateTime.parse("2021-06-05 10:00:24", df);
        LocalDateTime end = LocalDateTime.parse("2021-06-05 14:00:24", df);
        meeting.setTimeBegin(begin);
        meeting.setTimeEnd(end);
        List<Meeting> meetings = meetingMapper.selectMeetingByTime(begin, end, "第一次",null,null);
        meetings.stream().forEach(item->System.out.println(item));
    }

    @Test
    void testInsertMeeting1() {
        List<Meeting> meetings = meetingMapper.selectMeetingByUserId(111L);
        meetings.stream().forEach(item->System.out.println(item));
    }
}