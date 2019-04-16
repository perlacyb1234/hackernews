package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.Message;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.mapper.MessageMapper;
import com.cskaoyan.hackernews.mapper.UserMapper;
import com.cskaoyan.hackernews.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 20:47
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public int addMessage(int fromId, String toName, String content) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        User user = userMapper.selectByName(toName);
        int toId = user.getId();
        String conversationId = fromId <= toId ? (fromId + "_" + toId) : (toId + "_" + fromId);
        Message message = new Message();
        message.setToId(toId);
        message.setFromId(fromId);
        message.setContent(content);
        message.setCreatedDate(date);
        int insert = messageMapper.insert(message);
        return message.getId();
    }

    @Override
    public List<Message> selectByUserId(int id) {
        List<Message> messageList = messageMapper.selectByUserId(id);
        return messageList;
    }

    @Override
    public List<String> selectConversationIdByUserId(int id) {
        List<String> conversationId = messageMapper.selectConversationIdByUserId(id);
        return conversationId;
    }

    @Override
    public int selectCountGroupByConversationId(String conversationId) {
        int count = messageMapper.selectCountGroupByConversationId(conversationId);
        return count;
    }

    @Override
    public int readMessageByConversationId(String conversationId) {
        int update = messageMapper.updateMessageReadByConversationId(conversationId);
        return update;
    }

    @Override
    public List<Message> selectByConversationId(String conversationId) {
        List<Message> messageList = messageMapper.selectByConversationId(conversationId);
        return messageList;
    }
}
