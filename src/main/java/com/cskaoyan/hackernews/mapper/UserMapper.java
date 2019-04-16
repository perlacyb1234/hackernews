package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 14:47
 */
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    int addUser(@Param("name") String name,@Param("password") String password);

    List<User> selectAllUser();
}
