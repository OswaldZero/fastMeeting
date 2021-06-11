package com.meeting.wu.controller;

import com.meeting.wu.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@RestController
public class EmailController {
    @Autowired
    MailService mailService;
    @PostMapping("/sendEmail")
    public Long getEmail(@RequestParam("toAddress") String address){
        Long message = mailService.sendTextMail(address, "完美会议验证码");
        return message;
    }
}
