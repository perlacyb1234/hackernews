package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.Comment;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 22:07
 */
public interface CommentService {
    List<Comment> selectByEntityId(String newsId);

    boolean addComment(int newsId, String content, int userId);
}
