package com.wx.search.dto.weather;

import lombok.Data;

import java.io.Serializable;

/**
 *第二天温度
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class TomorrowDTO implements Serializable {
    private static final long serialVersionUID = -1665063060570417126L;
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
     * 小图标
     */
    private String weatherimg;
}
