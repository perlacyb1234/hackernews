package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by Cyb
 * Date 2019/4/12/012  Time 16:30
 */
@Service
public class RedisService {
    @Autowired
    NewsMapper newsMapper;
    public int dislike(int newsId, int userId) {
        Jedis jedis = new Jedis();
        jedis.srem("newsLike_" + newsId, String.valueOf(userId));
        Long sadd = jedis.sadd("newsDislike_" + newsId, String.valueOf(userId));
        int likeCount = selectLikeCount(newsId);
        int update = newsMapper.updateLikeCount(newsId,likeCount);
        return likeCount;
    }

    public int like(int newsId, int userId) {
        Jedis jedis = new Jedis();
        jedis.srem("newsDislike_" + newsId, String.valueOf(userId));
        Long sadd = jedis.sadd("newsLike_" + newsId, String.valueOf(userId));
        int likeCount = selectLikeCount(newsId);
        int update = newsMapper.updateLikeCount(newsId,likeCount);
        return likeCount;
    }

    private int selectLikeCount(int newsId){
        Jedis jedis = new Jedis();
        Long newsLike = jedis.scard("newsLike_" + newsId);
        Long newsDislike = jedis.scard("newsDislike_" + newsId);
        int likeCount = (int) (newsLike - newsDislike);
        return likeCount;
    }
}
