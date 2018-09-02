package com.wx.search.service.impl;

import com.wx.search.common.Movies2MoviesVOConverter;
import com.wx.search.common.enums.ResultEnum;
import com.wx.search.common.exception.SearchMovieException;
import com.wx.search.common.exception.ServiceExcepiton;
import com.wx.search.entity.Movies;
import com.wx.search.repository.MoviesRepository;
import com.wx.search.service.IMoviesService;
import com.wx.search.vo.MoviesVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author wangxu
 * @date 2018/8/2
 */
@Service
@Slf4j
public class MoviesServiceImpl implements IMoviesService{

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public Page<MoviesVO> findList(String q, Pageable pageable) {
        //根据标题查询
        Page<Movies> moviesPage = moviesRepository.findByTitleLikeOrderByYearDesc(q, pageable);
        //根据主演查询
        /*Page<Movies> mainActorLike = moviesRepository.findByMainActorLike(q, pageable);*/
        //国家查询
        /*Page<Movies> countryLike = moviesRepository.findByCountryLike(q, pageable);*/
        //按语言查询
        /*Page<Movies> lanLike = moviesRepository.findByLanLike(q, pageable);*/
        List<MoviesVO> list = Movies2MoviesVOConverter.convert(moviesPage.getContent());
       /* List<MoviesVO> list2 = Movies2MoviesVOConverter.convert(mainActorLike.getContent());
        List<MoviesVO> list3 = Movies2MoviesVOConverter.convert(countryLike.getContent());
        List<MoviesVO> list4 = Movies2MoviesVOConverter.convert(lanLike.getContent());*/
        if(!CollectionUtils.isEmpty(list)){
            log.info("list{}",list);
            return new PageImpl<MoviesVO>(list,pageable,moviesPage.getTotalElements());
        }
        /*if(!CollectionUtils.isEmpty(list2)){
            log.info("list2{}",list2);
            return new PageImpl<MoviesVO>(list2,pageable,mainActorLike.getTotalElements());
        }
        if(!CollectionUtils.isEmpty(list3)){
            log.info("list3{}",list3);
            return new PageImpl<MoviesVO>(list3,pageable,countryLike.getTotalElements());
        }
        if(!CollectionUtils.isEmpty(list4)){
            log.info("list4{}",list4);
            return new PageImpl<MoviesVO>(list4,pageable,lanLike.getTotalElements());
        }*/
        log.error("搜索的电影资源不存在{}",ResultEnum.MOVIES_NOT_EXIT);
        throw new ServiceExcepiton(ResultEnum.MOVIES_NOT_EXIT);
    }

    @Override
    public Page<MoviesVO> findByTitleLikeOrderByYearAsc(String title, Pageable pageable) {
       if(StringUtils.isBlank(title)){
           title="";
       }
        Page<Movies> movies = moviesRepository.findByTitleLikeOrderByYearDesc(title, pageable);
        List<MoviesVO> voList = Movies2MoviesVOConverter.convert(movies.getContent());
        return new PageImpl<MoviesVO>(voList,pageable,movies.getTotalElements());
    }

    @Override
    public MoviesVO findById(String id) {
        Optional<Movies> movies = moviesRepository.findById(id);
        if(movies ==null){
            log.error("搜索的电影资源不存在{}",ResultEnum.MOVIES_NOT_EXIT);
            throw new ServiceExcepiton(ResultEnum.MOVIES_NOT_EXIT);
        }
        MoviesVO vo=new MoviesVO();
        BeanUtils.copyProperties(movies.get(),vo);
        return vo;
    }
}
