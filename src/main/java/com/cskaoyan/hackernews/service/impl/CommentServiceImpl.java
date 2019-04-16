package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.mapper.CommentMapper;
import com.cskaoyan.hackernews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 22:11
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> selectByEntityId(String newsId) {
        List<Comment> commentList = commentMapper.selectByEntityId(newsId);
        return commentList;
    }

    @Override
    public boolean addComment(int newsId, String content, int userId) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        int insert = commentMapper.insert(newsId,content,userId,date);
        return insert == 1;
    }
}
