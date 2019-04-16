package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.mapper.UserMapper;
import com.cskaoyan.hackernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cyb
 * Date 2019/4/11/011  Time 16:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User register(String username, String password) {
        int i = userMapper.addUser(username, password);
        if ( i == 1){
            return userMapper.selectByName(username);
        }
        return null;
    }

    @Override
    public User selectById(int fromId) {
        User user = userMapper.selectById(fromId);
        return user;
    }

    @Override
    public User login(String username, String password) {
        List<User> userList = userMapper.selectAllUser();
        for (User user : userList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public boolean isUsernameExist(String username) {
        User user = userMapper.selectByName(username);
        if (user != null){
            return true;
        }
        return false;
    }
}
