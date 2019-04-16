package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.Message;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 20:48
 */
public interface MessageMapper {

    int insert(Message message);

    List<Message> selectByConversationId(String conversationId);

    List<Message> selectByUserId(int id);

    int selectCountGroupByConversationId(String conversationId);

    List<String> selectConversationIdByUserId(int id);

    int updateMessageReadByConversationId(String conversationId);
}
