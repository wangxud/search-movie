package com.wx.search.spider;

import com.wx.search.entity.Movies;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wangxu
 * @date 2018/7/21
 */
public class JsoupDemo {
    public List<String> link(String url) throws Exception{
        //由于获取的连接只是一部分,所以要拼接
        String link="http://www.bttiantangs.com";
        List <String > href=new ArrayList<>();
        Connection conn= Jsoup.connect(url).timeout(30000);
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Encoding", "gzip, deflate, sdch");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        Document doc=conn.get();
        //System.out.println(doc.html());
        Elements ele=doc.select(".article >h2>a");
        for(Element element:ele){
            String a=element.attr("href");
            //拼接完整的连接
            String full=link+a;
            href.add(full);
        }
        return href;

    }

    public List<Movies> get(List<String> href) throws IOException {
        List<Movies> ls=new ArrayList<>();
        for(String h:href){
            Movies m=new Movies();
            Connection conn=Jsoup.connect(h).timeout(60000);
            conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.header("Accept-Encoding", "gzip, deflate, sdch");
            conn.header("Accept-Language", "zh-CN,zh;q=0.8");
            conn.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
            Document doc;
            try {
                doc = conn.get();
            }catch (IOException e){
                conn=Jsoup.connect("https://www.bttiantangs.com/movie/50680.html").timeout(60000);
                doc = conn.get();
                e.printStackTrace();
            }
            //电影标题
            Elements ele_title=doc.select(".article_container >h1");
            m.setTitle(ele_title.get(0).text());

            //电影其他信息
            Elements ele_p=doc.select("#post_content :nth-child(2)");
            String p=ele_p.text();
            String sum[]=p.split("◎");
            for(String s:sum){
                //年代截取
                if(s.contains("年　　代")){
                    m.setYear(s.substring(5, s.length()));
                }
                //国家截取
                if(s.contains("国　　家")){
                    m.setCountry(s.substring(5, s.length()));
                }
                //语言截取
                if(s.contains("语　　言")){
                    m.setLan(s.substring(5, s.length()));
                }
                //豆瓣链接
                if(s.contains("豆瓣链接")){
                    m.setDownloadUrl(s.substring(5, s.length()));
                }
                //主演
                if(s.contains("主　　演")){
                    m.setMainActor(s.substring(5, s.length()));
                }

            }
            //电影图片
            Elements ele_img=doc.select(".tpic-cont-s >img:nth-child(1)");
            //有的不存在电影图片
            if(!ele_img.isEmpty()){
                m.setImgUrl(ele_img.attr("src"));
            }

            //电影简介
            Elements ele_introduce =doc.select(".minfos");
            //有的不存在电影简介
            if(!ele_introduce.isEmpty()){
                m.setIntroduce(ele_introduce.text());
            }
            //电影下载地址
            Elements ele_download=doc.select(".dlist >li >a:nth-child(2)");
            if(!ele_download.isEmpty()){
                m.setDownloadUrl(ele_download.get(0).attr("href"));
            }
            ls.add(m);
        }
        return ls;
    }
}
