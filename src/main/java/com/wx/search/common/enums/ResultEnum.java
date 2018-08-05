package com.wx.search.common.enums;

import lombok.Getter;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Getter
public enum ResultEnum {
    IP_ERROR(90,"获取地理位置失败"),
    WEATHER_ERROR(91,"获取天气失败"),
    STATUS_ERROR(93,"获取"),
    MOVIES_NOT_EXIT(94,"资源不存在"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
