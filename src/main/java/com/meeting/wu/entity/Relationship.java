package com.meeting.wu.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relationship {
    Long userId;
    Integer meetingId;
    Integer status;
}
