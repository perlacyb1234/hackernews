package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.Message;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 20:47
 */
public interface MessageService {
    int addMessage(int fromId, String toName, String content);

    List<Message> selectByConversationId(String conversationId);

    List<Message> selectByUserId(int id);

    int selectCountGroupByConversationId(String conversationId);

    List<String> selectConversationIdByUserId(int id);

    int readMessageByConversationId(String conversationId);
}
