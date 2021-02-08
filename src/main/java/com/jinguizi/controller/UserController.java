package com.jinguizi.controller;

import com.jinguizi.pojo.Result;
import com.jinguizi.pojo.ResultCode;
import com.jinguizi.pojo.User;
import com.jinguizi.service.UserService;
import com.jinguizi.utils.JwtUtil;
import com.jinguizi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-04 17:23
 **/
@RestController
@RequestMapping("jinguizi/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final long EXPIRE_TIME=60*3*60*1000;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("login")
    public Result findUserByNameAndPassword(@RequestBody User user, HttpSession session){

        //判断user表中是否存在该用户
        user.setPassword(MD5Util.encodeByMd5(user.getPassword()));
        User user2 = userService.findUserByNameAndPassword(user);
        //不存在就返回失败
        if(user2==null){
            return Result.failure(ResultCode.FAIL);
        }
        try {
            //存在的话，就通过jwtUtil创建一个token，返回给前端
            String token = jwtUtil.createJWT(user2.getId() + "", "user", Long.parseLong(EXPIRE_TIME+""));
            session.setAttribute("id",user2.getId());
            Map<String, Object> map = new HashMap<>();
            map.put("token",token);
            map.put("user",user2);
            return Result.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }
}
