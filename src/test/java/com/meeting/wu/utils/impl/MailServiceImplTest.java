package com.meeting.wu.utils.impl;

import com.meeting.wu.WuApplication;
import com.meeting.wu.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WuApplication.class)
class MailServiceImplTest {
    @Autowired
    MailService mailService;
    @Test
    public void testMail(){
        mailService.sendTextMail("1916296489@qq.com","验证码");
    }
}