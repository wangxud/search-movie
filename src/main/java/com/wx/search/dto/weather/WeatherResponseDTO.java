package com.wx.search.dto.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class WeatherResponseDTO implements Serializable {
    private static final long serialVersionUID = -8035386230337426676L;
    /**
     * 反馈代码 0成功
     */
    private String status;
    /**
     * 反馈信息
     */
    private String msg;
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
    /**
     * 第二天天气简报
     */
    private String tomorrow;


}
