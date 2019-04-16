package com.cskaoyan.hackernews.utils;

import com.cskaoyan.hackernews.bean.News;

import java.util.*;

/**
 * Created by Cyb
 * Date 2019/4/16/016  Time 15:33
 */
public class NewsSortUtil {
    public static List<News> sortNews(List<News> newsList){
        long l = System.currentTimeMillis();

        for (News news : newsList) {
            Date createdDate = news.getCreatedDate();
            Integer likeCount = news.getLikeCount();
            Integer commentCount = news.getCommentCount();
            long l2= createdDate.getTime();
            int time = (int) (l2 - l/3600000);
            double rank = (likeCount * 0.8 + commentCount * 0.2) / (time + 2) * (time + 2);
            news.setRank(rank);
        }
        Collections.sort(newsList, new NewsComparator());
        return newsList;
    }
}


