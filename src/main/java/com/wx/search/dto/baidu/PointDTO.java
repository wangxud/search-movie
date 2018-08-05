package com.wx.search.dto.baidu;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class PointDTO implements Serializable{
    private static final long serialVersionUID = 292481613989900042L;
    /**
     * 当前城市中心点经度
     */
    private String x;
    /**
     * 当前城市中心点纬度
     */
    private String y;
}
