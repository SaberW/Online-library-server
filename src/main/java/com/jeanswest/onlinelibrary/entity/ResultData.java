package com.jeanswest.onlinelibrary.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author :肖钊容
 * @date :2019-06-26 19:11
 * @description :返回数据
 */
@Data
@Component
public class ResultData {
    private Integer code;
    private String msg;
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }
}
