package com.wx.search.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Data
@Component
public class ConstProperties {
    /**
     *百度地图key
     */
    @Value("${baidu.key}")
    private String baiduKey;
    /**
     *地理位置查询接口地址
     */
    @Value("${baidu.url}")
    private String baiduUrl;
    /**
     *状态码 0:正确
     */
    @Value("${status.code}")
    private String statusCode;
    /**
     *天气接口查询地址
     */
    @Value("${weather.url}")
    private String weatherUrl;


    @Value("${hf.weather.key}")
    private String hfWeatherKey;

    @Value("${hf.weather.url}")
    private String hfWeatherUrl;
}
