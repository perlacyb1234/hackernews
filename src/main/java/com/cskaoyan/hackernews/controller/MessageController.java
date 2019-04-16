package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.Conversation;
import com.cskaoyan.hackernews.bean.Message;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.MessageService;
import com.cskaoyan.hackernews.service.UserService;
import com.cskaoyan.hackernews.vo.ConversationVo;
import com.cskaoyan.hackernews.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 20:42
 */
@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;
    @RequestMapping("/user/msg/addMessage")
    @ResponseBody
    public Map addMessage(HttpServletRequest request, String toName, String content){
        User user = (User) request.getSession().getAttribute("user");
        int msgId = messageService.addMessage(user.getId(),toName,content);
        Map map = new HashMap<String, Object>();
        map.put("code",msgId);
        return map;
    }
    @RequestMapping("/msg/detail")
    public String msgDetail(Model model, String conversationId){
        List<Message> messageList = messageService.selectByConversationId(conversationId);
        List<MessageVo> messageVos = new ArrayList<>();
        for (Message message : messageList) {
            User user = userService.selectById(message.getFromId());
            messageVos.add(new MessageVo(user.getId(),user.getHeadUrl(),message));
        }
        model.addAttribute("messages",messageVos);
        messageService.readMessageByConversationId(conversationId);
        return "letterDetail";
    }
    @RequestMapping("msg/list")
    public String list(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<String> conversationId = messageService.selectConversationIdByUserId(user.getId());
        List<ConversationVo> conversationVos = new ArrayList<>();
        for (String s : conversationId) {
            List<Message> messageList = messageService.selectByConversationId(s);
            int unread = 0;
            for (Message message : messageList) {
                if(message.getHasRead()==0){
                    unread++;
                }
            }
            Message message = messageList.get(0);
            int count = messageList.size();
            //int count = messageService.selectCountGroupByConversationId(message.getConversationId());
            if (message.getFromId()!=user.getId()) {
                conversationVos.add(new ConversationVo(userService.selectById(message.getFromId()),
                        new Conversation(message.getConversationId(), message.getCreatedDate(),
                                count, message.getContent()),unread));
            }
            else /*if (message.getToId()!=user.getId())*/
            {
                conversationVos.add(new ConversationVo(userService.selectById(message.getToId()),
                        new Conversation(message.getConversationId(),message.getCreatedDate(),
                                count,message.getContent()),unread));
            }
        }
        /*for (Message message : messageList) {
            int count = messageService.selectCountGroupByConversationId(message.getConversationId());
            if (message.getFromId()!=user.getId()) {
                User user1 = userService.selectById(message.getFromId());
                Conversation conversation = new Conversation(message.getConversationId(), message.getCreatedDate(),
                        count, message.getContent());
                conversationVos.add(new ConversationVo(userService.selectById(message.getFromId()),
                                new Conversation(message.getConversationId(), message.getCreatedDate(),
                                        count, message.getContent())));
            }
            else {
                conversationVos.add(new ConversationVo(userService.selectById(message.getToId()),
                        new Conversation(message.getConversationId(),message.getCreatedDate(),
                                count,message.getContent())));
            }*/
        request.setAttribute("conversations",conversationVos);
        return "letter";
    }
}
