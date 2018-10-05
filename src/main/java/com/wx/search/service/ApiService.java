package com.wx.search.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.search.common.Utils;
import com.wx.search.common.enums.ResultEnum;
import com.wx.search.common.exception.SearchMovieException;
import com.wx.search.common.properties.ConstProperties;
import com.wx.search.dto.baidu.AddressDetailDTO;
import com.wx.search.dto.baidu.BaiDuResponseDTO;
import com.wx.search.dto.baidu.ContentDTO;
import com.wx.search.dto.weather.DailyForecast;
import com.wx.search.vo.WeatherResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
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
            /**
             * 中文需要urlencode
             *https://free-api.heweather.com/s6/weather/forecast?location=重庆&key=xxx
             */
            String resweather = restTemplate.getForObject(constProperties.getHfWeatherUrl()+"?location="+addressDetail.getCity()+"&key="+constProperties.getHfWeatherKey(), String.class);
            JSONObject json = JSONObject.parseObject(resweather);
            JSONArray jsonArray = json.getJSONArray("HeWeather6");
            DailyForecast dy=new DailyForecast();
            for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                String status = (String) jo.get("status");
                if("ok".equals(status)){
                    //获取天气详情
                    String dailyForecast = jo.getString("daily_forecast");
                    List<DailyForecast> list = JSONObject.parseArray(dailyForecast, DailyForecast.class);
                    list.sort((DailyForecast d1,DailyForecast d2) -> d1.getDate().compareTo(d2.getDate()));
                    dy=list.get(0);
                    BeanUtils.copyProperties(dy,weatherResponseVO);
                    weatherResponseVO.setCity(addressDetail.getCity());
                    weatherResponseVO.setTemp(dy.getTmp_min()+"℃"+"-"+dy.getTmp_max()+"℃");
                    redisTemplate.opsForValue().set(Utils.getIp(request),weatherResponseVO,3600, TimeUnit.MINUTES);
                }
            }
            System.out.println("dy======"+dy);
            log.info("no-redis-userResponse={}",weatherResponseVO);
        }else{
            weatherResponseVO=(WeatherResponseVO) key;
            log.info("weatherResponseVO={}",weatherResponseVO);
        }
        return weatherResponseVO;
    }

    private static String strEncode(String str){
        String encode="";
        try {
             encode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

}
