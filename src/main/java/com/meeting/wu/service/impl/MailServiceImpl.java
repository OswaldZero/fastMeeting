package com.meeting.wu.service.impl;

import com.meeting.wu.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Service
public class MailServiceImpl implements MailService {



    @Autowired
    private JavaMailSender mailSender;

    // 注入常量
    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 发送文本邮件
     * @param toAddr
     * @param title
     */
    @Override
    public Long sendTextMail(String toAddr, String title) {
        // 纯文本邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toAddr);
        message.setSubject(title);
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = now.atZone(zoneId).toInstant();
        long l = instant.toEpochMilli();
        l=l%100000;
        message.setText("您的验证码是: "+l);
        mailSender.send(message);
        return l;
    }
}

