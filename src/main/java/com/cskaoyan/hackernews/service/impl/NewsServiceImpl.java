package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.mapper.NewsMapper;
import com.cskaoyan.hackernews.service.NewsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/10/010  Time 22:38
 */
@Service
public class NewsServiceImpl implements NewsSerivce {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public News selectNewsById(String id) {
        News news = newsMapper.selectById(Integer.parseInt(id));
        return news;
    }

    @Override
    public boolean addCommentCount(int newsId) {
        int update = newsMapper.addCommentCount(newsId);
        return update == 1;
    }

    @Override
    public boolean addNews(News news, int id) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        news.setCreatedDate(date);
        int insert = newsMapper.insert(news,id);
        return insert == 1;
    }

    @Override
    public List<News> selectAllNews() {
        List<News> newsList = newsMapper.selectAllNews();
        return newsList;
    }
}
