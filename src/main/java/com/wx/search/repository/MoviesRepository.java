package com.wx.search.repository;

import com.wx.search.entity.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author wangxu
 * @date 2018/7/21
 */
public interface MoviesRepository extends MongoRepository<Movies,String> {
    /**
     * 根据标题模糊查询
     * @param title
     *          标题
     * @param pageable
     * @return
     */
    Page<Movies> findByTitleLike(String title, Pageable pageable);

    /**
     * 根据主演查询
     * @param mainActor
     * @param pageable
     * @return
     */
    Page<Movies> findByMainActorLike(String mainActor, Pageable pageable);

    /**
     * 根据国家查询
     * @param country
     * @param pageable
     * @return
     */
    Page<Movies> findByCountryLike(String country, Pageable pageable);

    /**
     * 根据语言查询
     * @param lan
     * @param pageable
     * @return
     */
    Page<Movies> findByLanLike(String lan, Pageable pageable);

    /**
     * 根据标题查询并按照时间排序
     * @param title
     * @param pageable
     * @return
     */
    Page<Movies>findByTitleLikeOrderByYearDesc(String title, Pageable pageable);

    /**
     * 根据标题查询
     * @param title
     * @return
     */
    Movies findByTitle(String title);

}
