package com.wx.search.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author wangxu
 * @date 2018/7/21
 */
@Data
public class MoviesVO implements Serializable{
    private static final long serialVersionUID = 4156761932441009424L;

    private String id;
    /**
     * 电影标题
     */
    private String title;
    /**
     * 电影年份
     */
    private String year;
    /**
     * 国家
     */
    private String country;
    /**
     * 语言
     */
    private String lan;
    /**
     * 豆瓣连接
     */
    private String doubanLink;
    /**
     * 简介
     */
    private String introduce;
    /**
     * 主演
     */
    private String mainActor;
    /**
     * 下载地址
     */
    //@Indexed(unique=true)
    private String downloadUrl;
    /**
     * 图片下载地址
     */
    private String imgUrl;
}
