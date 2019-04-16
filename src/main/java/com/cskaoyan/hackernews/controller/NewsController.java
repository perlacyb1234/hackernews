package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.CommentService;
import com.cskaoyan.hackernews.service.NewsSerivce;
import com.cskaoyan.hackernews.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 20:27
 */
@Controller
public class NewsController {
    @Autowired
    NewsSerivce newsSerivce;
    @Autowired
    CommentService commentService;

    @RequestMapping("/user/addNews")
    @ResponseBody
    public Map addNews(News news, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean ret = newsSerivce.addNews(news,user.getId());
        Map map = new HashMap<String,Object>();
        map.put("code",1);
        if (ret){
            map.put("code",0);
            return map;
        }
        return map;
    }
    @RequestMapping("/news/{newsId}")
    public String newsDetail(@PathVariable("newsId")String newsId, Model model){
        News news = newsSerivce.selectNewsById(newsId);
        //图片显示缩略尺寸,80*100
        String image = news.getImage();
        news.setImage(image + "?x-oss-process=image/resize,m_fixed,h_80,w_100");
        model.addAttribute("news",news);
        model.addAttribute("owner",news.getUser());
        List<Comment> comments = commentService.selectByEntityId(newsId);
        List<ResponseVo> responseVos = new ArrayList<>();
        for (Comment comment : comments) {
            responseVos.add(new ResponseVo(comment.getUser(),0,comment));
        }
        model.addAttribute("comments",responseVos);
        model.addAttribute("like",news.getLikeCount());
        return "detail";
    }
}
