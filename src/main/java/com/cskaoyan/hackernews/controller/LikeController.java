package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.MessageService;
import com.cskaoyan.hackernews.service.NewsSerivce;
import com.cskaoyan.hackernews.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyb
 * Date 2019/4/12/012  Time 16:25
 */
@Controller
public class LikeController {
    @Autowired
    RedisService redisService;
    @Autowired
    MessageService messageService;
    @Autowired
    NewsSerivce newsSerivce;
    @RequestMapping("/like")
    @ResponseBody
    public Map like(int newsId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        int like = redisService.like(newsId, user.getId());
        News news = newsSerivce.selectNewsById(String.valueOf(newsId));
        //此处可以异步处理
        messageService.addMessage(user.getId(),news.getUser().getName(),user.getName() + "赞了你的资讯,http://localhost:8080/news/" + news.getId());
        Map map = new HashMap();
        map.put("code",1);
        if (like!=0){
            map.put("code",0);
            map.put("msg",like);
        }
        return map;
    }

    @RequestMapping("/dislike")
    @ResponseBody
    public Map dislike(int newsId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        int dislike = redisService.dislike(newsId, user.getId());
        System.out.println(dislike);
        Map map = new HashMap();
        map.put("code",1);
        if (dislike != 0){
            map.put("code",0);
            map.put("msg",dislike);
        }
        return map;
    }
}
