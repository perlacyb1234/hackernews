package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.NewsSerivce;
import com.cskaoyan.hackernews.service.UserService;
import com.cskaoyan.hackernews.utils.NewsSortUtil;
import com.cskaoyan.hackernews.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/10/010  Time 20:20
 */
@Controller
public class MainController {

    @Autowired
    NewsSerivce newsSerivce;
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
        if (session.getAttribute("contextPath")==null){
            session.setAttribute("contextPath",contextPath);
        }
        List<News> newsList = newsSerivce.selectAllNews();
        List<News> newsList2 = NewsSortUtil.sortNews(newsList);
        List<ResponseVo> responseVos = new ArrayList<>();
        for (News news : newsList2) {
            responseVos.add(new ResponseVo(news.getUser(),news.getLikeCount(),news));
        }
        model.addAttribute("vos",responseVos);
        return "home";

    }
}
