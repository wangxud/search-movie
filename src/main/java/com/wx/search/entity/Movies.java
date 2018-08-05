package com.wx.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * 电影
 * @author wangxu
 * @date 2018/8/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
    @Id
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
