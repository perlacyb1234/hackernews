package com.cskaoyan.hackernews.vo;

import com.cskaoyan.hackernews.bean.Message;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 21:23
 */
public class MessageVo {
    private int userId;
    private String headUrl;
    private Message message;

    public MessageVo() {
    }

    public MessageVo(int userId, String headUrl, Message message) {
        this.userId = userId;
        this.headUrl = headUrl;
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
