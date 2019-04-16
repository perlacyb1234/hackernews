package com.cskaoyan.hackernews.bean;

import java.util.Date;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 23:28
 */
public class Conversation {
    private String conversationId;
    private Date createdDate;
    private int id;
    private String content;

    public Conversation() {
    }

    public Conversation(String conversationId, Date createdDate, int id, String content) {
        this.conversationId = conversationId;
        this.createdDate = createdDate;
        this.id = id;
        this.content = content;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
