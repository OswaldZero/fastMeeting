package com.meeting.wu.controller;

import com.meeting.wu.entity.Meeting;
import com.meeting.wu.entity.Option;
import com.meeting.wu.service.MeetingService;
import com.meeting.wu.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/search")
    @ApiOperation("搜索会议")
    @ApiImplicitParam(name = "option",value = "查找条件",paramType = "body",dataType ="Option")
    public Result search(@RequestBody Option option){
        return meetingService.selectMeeting(option);
    }

    @PostMapping("/create")
    @ApiOperation("创建会议")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meeting",value = "会议",paramType = "body",dataType ="Meeting"),
            @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType ="Long")
    })
    public Result createMeeting(@RequestBody Meeting meeting, @RequestParam("userId") Long userId){
        return meetingService.createMeeting(meeting,userId);
    }
    @PostMapping("/searchByUserId")
    @ApiOperation("按用户id搜索会议")
    @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType ="Long")
    public Result searchByUserId(@RequestParam("userId") Long userId){
        return meetingService.selectMeetingByUserId(userId);
    }
    @PostMapping("/signUp")
    @ApiOperation("会议签到")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meetingId",value = "会议签到码(会议id)",paramType = "query",dataType ="Integer"),
            @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType ="Long"),
            @ApiImplicitParam(name = "longitude",value = "经度",paramType = "query",dataType = "BigDecimal"),
            @ApiImplicitParam(name = "latitude",value = "纬度",paramType = "query",dataType = "BigDecimal")
    })
    public Result signUp(@RequestParam("meetingId") Integer meetingId, @RequestParam("userId") Long userId, @RequestParam("longitude") BigDecimal longitude,@RequestParam("latitude") BigDecimal latitude){
        return meetingService.signUp(meetingId, userId, longitude, latitude);
    }
    @GetMapping("/selectUserByMeetingId")
    @ApiOperation("按会议id选择用户")
    @ApiImplicitParam(name = "meetingId",value = "会议id",paramType = "query",dataType = "Integer")
    public Result selectUserByMeetingId(@RequestParam("meetingId") Integer meetingId){
        return meetingService.selectUserByMeetingId(meetingId);
    }

}
