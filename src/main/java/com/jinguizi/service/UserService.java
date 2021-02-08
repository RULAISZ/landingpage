package com.jinguizi.service;

import com.jinguizi.mapper.UserMapper;
import com.jinguizi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-04 17:24
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByNameAndPassword(User user) {
        return userMapper.findUserByNameAndPassword(user);
    }
}
