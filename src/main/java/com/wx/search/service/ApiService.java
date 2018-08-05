package com.wx.search.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.search.common.Utils;
import com.wx.search.common.enums.ResultEnum;
import com.wx.search.common.exception.SearchMovieException;
import com.wx.search.common.properties.ConstProperties;
import com.wx.search.dto.baidu.AddressDetailDTO;
import com.wx.search.dto.baidu.BaiDuResponseDTO;
import com.wx.search.dto.baidu.ContentDTO;
import com.wx.search.dto.weather.WeatherResponseDTO;
import com.wx.search.vo.WeatherResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 第三方接口
 * @author wangxu
 * @date 2018/8/2
 */
@Service
@Slf4j
public class ApiService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConstProperties constProperties;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public WeatherResponseVO getIp(HttpServletRequest request){
        Object key = redisTemplate.opsForValue().get(Utils.getIp(request));
        BaiDuResponseDTO baiDuResponse=new BaiDuResponseDTO();
        WeatherResponseDTO weatherResponse=new WeatherResponseDTO();
        WeatherResponseVO weatherResponseVO=new WeatherResponseVO();
        if(key==null){
            String ipAddress = Utils.getIp(request);
            String result=restTemplate.getForObject(constProperties.getBaiduUrl()+"?ip="+ipAddress+"&ak="+constProperties.getBaiduKey()+"&coor=bd09ll",String.class);
            String resip = Utils.unicodeToUtf8(result);
            baiDuResponse = JSONObject.parseObject(resip, BaiDuResponseDTO.class);
            if(!constProperties.getStatusCode().equals(baiDuResponse.getStatus())){
                log.error("baidu.status.code{}",baiDuResponse.getStatus());
                throw new SearchMovieException(ResultEnum.IP_ERROR);
            }
            ContentDTO content = JSONObject.parseObject(baiDuResponse.getContent(), ContentDTO.class);
            AddressDetailDTO addressDetail = JSONObject.parseObject(content.getAddress_detail(), AddressDetailDTO.class);
            String resweather = restTemplate.getForObject(constProperties.getWeatherUrl() + addressDetail.getCity(), String.class);
            weatherResponse=JSONObject.parseObject(resweather,WeatherResponseDTO.class);
            if(!constProperties.getStatusCode().equals(weatherResponse.getStatus())){
                log.error("weather.status.code{}",baiDuResponse.getStatus());
                throw new SearchMovieException(ResultEnum.WEATHER_ERROR);
            }
            BeanUtils.copyProperties(weatherResponse,weatherResponseVO);

            redisTemplate.opsForValue().set(Utils.getIp(request),weatherResponseVO,3600, TimeUnit.MINUTES);
            log.info("no-redis-userResponse={}",weatherResponseVO);
        }else{
            weatherResponseVO=(WeatherResponseVO) key;
            log.info("weatherResponseVO={}",weatherResponseVO);
        }
        return weatherResponseVO;
    }
}
