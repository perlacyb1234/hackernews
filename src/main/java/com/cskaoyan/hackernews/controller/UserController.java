package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 16:10
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    @ResponseBody
    public Map reg(String username, String password, HttpServletRequest request) {
        boolean ret = userService.isUsernameExist(username);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 1);
        if (ret) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }
        User user = userService.register(username, password);
        if (user != null) {
            map.put("code", 0);
            request.getSession().setAttribute("user",user);
            return map;
        }
        return map;
    }
    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password, HttpServletRequest request) {
        User user = userService.login(username,password);
        Map map = new HashMap<String,Object>();
        boolean ret = userService.isUsernameExist(username);
        map.put("code", 1);
        if (!ret){
            map.put("msgname","用户名不存在");
            return map;
        }
        if (user !=null){
            request.getSession().setAttribute("user",user);
            map.put("code",0);
            return map;
        }
        map.put("msgpwd","密码不正确");
        return map;
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
    @RequestMapping("user/tosendmsg")
    public String toSendMsg(){
        return "sendmsg";
    }
    @RequestMapping("user/{id}")
    public String personal(@PathVariable int id, Model model){
        User user = userService.selectById(id);
        model.addAttribute("user",user);
        return "personal";
    }
}
