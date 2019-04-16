package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.User;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 16:12
 */
public interface UserService {
    User register(String username, String password);
    boolean isUsernameExist(String username);

    User login(String username, String password);

    User selectById(int fromId);
}