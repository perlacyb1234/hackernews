package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.CommentService;
import com.cskaoyan.hackernews.service.MessageService;
import com.cskaoyan.hackernews.service.NewsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 22:07
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    NewsSerivce newsSerivce;
    @Autowired
    MessageService messageService;
    @RequestMapping("addComment")
    public String addConmment(HttpServletRequest request, int newsId, String content){
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        boolean ret = commentService.addComment(newsId,content,userId);
        //以下步骤可以异步处理
        News news = newsSerivce.selectNewsById(String.valueOf(newsId));
        newsSerivce.addCommentCount(newsId);
        messageService.addMessage(user.getId(),news.getUser().getName(),
                user.getName() + "评论了" + news.getUser().getName() + "的资讯：http://localhost:8080/news/," +
                        "内容：" + news.getId() + "," + content);
        return  "redirect:/news/" + newsId;
    }
}
