package com.meeting.wu.utils;

import lombok.Data;

import javax.xml.ws.handler.Handler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2021/6/5
 */
@Data
public class Result{
    int code;
    Object value;
    public Result(int code, Object object){
        this.code=code;
        this.value=object;
    }
}
