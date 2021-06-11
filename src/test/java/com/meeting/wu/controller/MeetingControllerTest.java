package com.meeting.wu.controller;

import com.meeting.wu.WuApplication;
import com.meeting.wu.entity.Option;
import com.meeting.wu.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = WuApplication.class)
class MeetingControllerTest {
    @Autowired
    public MeetingController meetingController;
    @Test
    void search() {
        meetingController.signUp(3,20183L,new BigDecimal(123),new BigDecimal(122));
    }

    @Test
    void testSearch() {
        Option option = new Option();
        option.setPage(1);
        option.setSize(10);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime begin = LocalDateTime.parse("2021-06-01 10:00:24", df);
        LocalDateTime end = LocalDateTime.parse("2021-07-02 14:00:24", df);
        option.setMeetingName("之");
        option.setTimeBegin(begin);
        option.setTimeEnd(end);
        Result search = meetingController.search(option);
        System.out.println(search);

    }
}