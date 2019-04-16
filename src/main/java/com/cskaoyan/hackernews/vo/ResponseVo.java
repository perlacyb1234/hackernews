package com.cskaoyan.hackernews.vo;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;

/**
 * Created by Cyb
 * Date 2019/4/10/010  Time 22:45
 */
public class ResponseVo<T> {
    private User user;
    private int like;
    private T t;

    public ResponseVo() {
    }

    public ResponseVo(User user, int like, T t) {
        this.user = user;
        this.like = like;
        this.t = t;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public T getT() {
        return t;
    }

    public T getNews(){
        return t;
    }
    public T getComment(){
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
