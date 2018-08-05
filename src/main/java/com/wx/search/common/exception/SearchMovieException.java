package com.wx.search.common.exception;

import com.wx.search.common.enums.ResultEnum;
import lombok.Getter;

/**
 *
 * @author wangxu
 * @date 2018/7/15
 */
@Getter
public class SearchMovieException extends RuntimeException {
    private Integer code;
    public SearchMovieException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SearchMovieException(Integer code, String message){
        super(message);
        this.code=code;
    }
}
