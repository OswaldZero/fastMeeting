package com.meeting.wu.service;

import org.springframework.stereotype.Service;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
public interface MailService {

    /**
     * 发送纯文本邮件
     * @param toAddr 发送给谁
     * @param title 标题
     */
    public Long sendTextMail(String toAddr, String title);

}
