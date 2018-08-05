package com.wx.search.common;

import com.wx.search.entity.Movies;
import com.wx.search.vo.MoviesVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wangxu
 * @date 2018/7/22
 */
public class Movies2MoviesVOConverter {
    public static List<MoviesVO> convert(List<Movies> moviesList){
        List<MoviesVO> moviesVOList=new ArrayList<>();
        for (Movies movies:moviesList){
            MoviesVO moviesVO=new MoviesVO();
            BeanUtils.copyProperties(movies,moviesVO);
            moviesVOList.add(moviesVO);
        }
        return moviesVOList;
    }
}
