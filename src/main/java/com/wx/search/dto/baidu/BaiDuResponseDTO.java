package com.wx.search.dto.baidu;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author wangxu
 * @date 2018/7/14
 */
@Data
public class BaiDuResponseDTO implements Serializable{

    private static final long serialVersionUID = 1936638585591146622L;
    /**
     * 详细地址信息
     */
    private String address;
    /**
     * 结构信息
     */
    private String content;
    /**
     * 结果状态返回码 0:正确
     */
    private String status;
}
