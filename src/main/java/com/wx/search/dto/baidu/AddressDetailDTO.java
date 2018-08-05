package com.wx.search.dto.baidu;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class AddressDetailDTO implements Serializable{
    private static final long serialVersionUID = -5744479872984396929L;
    /**
     * 城市
     */
    private String city;
    /**
     * 百度城市代码
     */
    private String city_code;
    /**
     * 区县
     */
    private String district;
    /**
     * 省份
     */
    private String province;
    /**
     * 街道
     */
    private String street;
    /**
     * 门牌号
     */
    private String street_number;
}
