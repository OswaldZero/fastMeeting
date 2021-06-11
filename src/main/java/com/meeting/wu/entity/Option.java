package com.meeting.wu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/7
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime timeBegin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime timeEnd;
    private String meetingName;
    private Integer page;
    private Integer size;
}
