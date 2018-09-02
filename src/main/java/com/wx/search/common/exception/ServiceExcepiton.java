package com.wx.search.common.exception;

import com.wx.search.common.enums.ResultEnum;
import lombok.Getter;

/**
 *
 * @author wangxu
 * @date 2018/9/2
 */
@Getter
public class ServiceExcepiton extends RuntimeException{
    private Integer code;
    public ServiceExcepiton(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public ServiceExcepiton(Integer code, String message){
        super(message);
        this.code=code;
    }
}
