package com.wx.search.dto.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wangxu on 2018/9/27.
 */
@Data
public class HeWeather6 implements Serializable{
    private static final long serialVersionUID = 8235985839441413173L;
    /**
     * 基础信息
     */
    private String basic;
    /**
     * 接口更新时间
     */
    private String update;
    /**
     * 接口状态
     */
    private String status;
    /**
     * 天气预报
     */
    private String daily_forecast;
}
