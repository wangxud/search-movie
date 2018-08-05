package com.wx.search.dto.baidu;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Data
public class ContentDTO implements Serializable{
    private static final long serialVersionUID = 2315072037457656330L;
    /**
     * 简要地址信息
     */
    private String address;
    /**
     * 结构化地址信息
     */
    private String address_detail;
    /**
     * 当前城市中心点
     */
    private String point;
}
