package com.wx.search.common;

import com.wx.search.service.ApiService;
import com.wx.search.vo.WeatherResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wangxu
 * @date 2018/7/28
 */
@Aspect
@Configuration
@Slf4j
public class LogRecordAspect {
    /*@Autowired
    private ApiService apiService;*/

    @Pointcut("execution(* com.wx.search.web.*Controller.*(..))")
    public void excudeService() {

    }
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        /*WeatherResponseVO data = apiService.getIp(request);
        request.setAttribute("d",data);*/
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        log.info("请求结束，controller的返回值是 " + result.toString());
        return result;
    }
}
