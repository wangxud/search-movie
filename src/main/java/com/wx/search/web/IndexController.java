package com.wx.search.web;

import com.wx.search.common.ResultVOUtil;
import com.wx.search.entity.Movies;
import com.wx.search.repository.MoviesRepository;
import com.wx.search.service.ApiService;
import com.wx.search.service.IMoviesService;
import com.wx.search.vo.MoviesVO;
import com.wx.search.vo.ResultVO;
import com.wx.search.vo.WeatherResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author wangxu
 * @date 2018/8/2
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ApiService apiService;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private IMoviesService moviesService;

    @GetMapping(value = {"","/"})
    public String index(){
        return "index";
    }


    @GetMapping("/ip")
    @ResponseBody
    public ResultVO<WeatherResponseVO> getIp(HttpServletRequest request){
        WeatherResponseVO userResponse = apiService.getIp(request);
        return ResultVOUtil.success(userResponse);
    }

    @PostMapping("/list")
    public ModelAndView list(String q, @RequestParam(defaultValue = "1",required = false) Integer page, Map<String, Object> map){
        log.info("检索{}：",q);
        if(StringUtils.isEmpty(q)){
            return new ModelAndView("error");
        }
        Integer size=10;
        PageRequest request = new PageRequest(page - 1, size);
        Page<MoviesVO> listPage = moviesService.findList(q, request);
        map.put("listPage", listPage);
        map.put("q", q);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("list", map);
    }

    @GetMapping("/list/{id}")
    public String detail(@PathVariable String id, Map<String, Object> map){
        System.out.println("id===="+id);
        MoviesVO vo = moviesService.findById(id);
        map.put("vo",vo);
        return "detail";
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }
}
