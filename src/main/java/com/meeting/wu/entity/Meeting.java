package com.meeting.wu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 会议室实体
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    Integer meetingId;
    String meetingName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    LocalDateTime timeBegin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    LocalDateTime timeEnd;
    BigDecimal longitude;
    BigDecimal latitude;
    BigDecimal radius;
    Integer status;
    String meetingDescription;
}
