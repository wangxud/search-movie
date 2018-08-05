package com.wx.search.vo;

import lombok.Data;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class WeatherResponseVO {
    /**
     * 反馈代码 0成功
     */
    private String status;
    /**
     * 城市
     */
    private String city;
    /**
     * AQI质量
     */
    private String aqi;
    /**
     * PM2.5质量
     */
    private String pm25;
    /**
     * 温度
     */
    private String temp;
    /**
     * 天气情况
     */
    private String weather;
    /**
     * 风向风力
     */
    private String wind;
    /**
     * 大图标
     */
    private String weatherimg;
}
