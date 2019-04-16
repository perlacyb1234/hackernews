package com.cskaoyan.hackernews.utils;

import com.cskaoyan.hackernews.bean.News;

import java.util.Comparator;

/**
 * Created by Cyb
 * Date 2019/4/16/016  Time 15:52
 */
public class NewsComparator implements Comparator<News> {
    @Override
    public int compare(News o1, News o2) {
        if (o1.getRank()!=o2.getRank()){
            return (int) (o2.getRank()-o1.getRank());
        }
        return (int) (o2.getCreatedDate().getTime()-o1.getCreatedDate().getTime());
    }
}
