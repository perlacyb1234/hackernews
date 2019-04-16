package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.News;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/10/010  Time 22:01
 */
public interface NewsSerivce {
    News selectNewsById(String id);
    List<News> selectAllNews();

    boolean addNews(News news, int id);

    boolean addCommentCount(int newsId);
}
