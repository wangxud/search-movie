package com.wx.search.spider;

import com.wx.search.entity.Movies;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *图片下载
 * @author wangxu
 * @date 2018/7/21
 */
public class BtPicture {
    public void download(Movies e) throws IOException {
        String url=e.getImgUrl();
        //图片链接有的没
        if(url=="null"){
            url="https://ws2.sinaimg.cn/large/6c7edb3fly1fguvf22hznj215o0k67h5.jpg";
        }
        Connection conn= Jsoup.connect(url);
        Connection.Response rs=conn.ignoreContentType(true).timeout(3000).ignoreHttpErrors(true).execute();
        //存放图片的数组
        byte b[]=rs.bodyAsBytes();
        File file = new File("/Downloads/BT_Movies_Picture",e.getTitle().replace(":", "")+".jpg");
        if (!file.exists()) {
            FileOutputStream raf = new FileOutputStream(file);
            raf.write(b);
            raf.close();
        }
    }

}
