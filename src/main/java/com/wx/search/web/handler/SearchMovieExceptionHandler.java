package com.wx.search.web.handler;

import com.wx.search.common.ResultVOUtil;
import com.wx.search.common.exception.SearchMovieException;
import com.wx.search.common.exception.ServiceExcepiton;
import com.wx.search.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wangxu
 * @date 2018/8/2
 */
@ControllerAdvice
public class SearchMovieExceptionHandler implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public SearchMovieExceptionHandler(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @ExceptionHandler(value = SearchMovieException.class)
    @ResponseBody
    public ResultVO handlerSearchHandlerException(SearchMovieException e){
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    @ExceptionHandler(value = ServiceExcepiton.class)
    public String handlerServiceHandlerException(ServiceExcepiton e,NativeWebRequest request){
        String p = request.getParameter("p");
        System.out.println("错误请求为====="+p);
        return "error";
    }
}
