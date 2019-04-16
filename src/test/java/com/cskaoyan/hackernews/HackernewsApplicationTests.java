package com.cskaoyan.hackernews;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.service.NewsSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HackernewsApplicationTests {

    @Autowired
    NewsSerivce newsSerivce;
    @Test
    public void contextLoads() {
        News news = newsSerivce.selectNewsById("46");
        System.out.println(news);
    }

}
