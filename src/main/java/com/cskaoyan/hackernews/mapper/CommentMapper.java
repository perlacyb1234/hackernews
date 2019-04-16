package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 22:12
 */
public interface CommentMapper {
    public List<Comment> selectByEntityId(String newsId);

    int insert(@Param("newsId") int newsId, @Param("content") String content, @Param("userId") int userId,@Param("createdDate") Date date);
}
