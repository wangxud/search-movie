package com.wx.search.service;

import com.wx.search.vo.MoviesVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author wangxu
 * @date 2018/8/2
 */
public interface IMoviesService {
    Page<MoviesVO> findList(String q, Pageable pageable);

    Page<MoviesVO>findByTitleLikeOrderByYearAsc(String title, Pageable pageable);

    MoviesVO findById(String id);
}
