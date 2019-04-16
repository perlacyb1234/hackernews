package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.News;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NewsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("news") News news, @Param("userId") int id);

    int insertSelective(News record);

    List<News> selectAllNews();
    News selectById(Integer id);

    //int updateByExampleSelective(@Param("record") news record, @Param("example") newsExample example);

    //int updateByExample(@Param("record") news record, @Param("example") newsExample example);

    int updateByIdSelective(News record);

    int updateById(News record);

    int addCommentCount(int newsId);

    int updateLikeCount(@Param("newsId") int newsId,@Param("likeCount") int likeCount);
}