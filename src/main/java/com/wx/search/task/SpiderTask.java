package com.wx.search.task;

import com.wx.search.entity.Movies;
import com.wx.search.repository.MoviesRepository;
import com.wx.search.spider.JsoupDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *爬虫定时任务
 * @author wangxu
 * @date 2018/7/22
 */
@Component
@Slf4j
public class SpiderTask {
    @Autowired
    private MoviesRepository moviesRepository;
    @Scheduled(cron ="0 09 23 * * ?" )
    public void spiderMovies(){
        try {
            //moviesRepository.deleteAll();
            log.info("开始爬虫任务");
            //用来计数
            int k=0;
            //用来下载图片
            //BtPicture p=new BtPicture();
            for(int i=2;i<50;i++){
                //爬取的地址
                String url="https://www.bttiantangs.com/list/dianying/index_"+i+".html";
                JsoupDemo jsoup=new JsoupDemo();
                //获取某一页的所有电影详情页下的连接
                List<String> href=jsoup.link(url);
                List <Movies> m=jsoup.get(href);
                for(Movies e:m){
                    System.out.println(e.toString());
                    k++;
                    if(StringUtils.isEmpty(moviesRepository.findByTitle(e.getTitle())) && !(StringUtils.isEmpty(e.getDownloadUrl()))){
                        moviesRepository.save(e);
                    }
                }
            }
        }catch (Exception e){
            System.out.println("爬虫任务失败");
            e.printStackTrace();
        }

    }
}
