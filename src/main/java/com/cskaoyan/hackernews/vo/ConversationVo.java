package com.cskaoyan.hackernews.vo;

import com.cskaoyan.hackernews.bean.Conversation;
import com.cskaoyan.hackernews.bean.Message;
import com.cskaoyan.hackernews.bean.User;

/**
 * Created by Cyb
 * Date 2019/4/15/015  Time 21:53
 */
public class ConversationVo {
    private User user;
    private Conversation conversation;
    private int unread;
    public ConversationVo() {
    }

    public ConversationVo(User user, Conversation conversation, int unread) {
        this.user = user;
        this.conversation = conversation;
        this.unread = unread;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
