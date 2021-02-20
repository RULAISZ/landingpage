package com.jinguizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-01 16:21
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test01(){
        redisTemplate.opsForList().leftPush("ss","ss");
        //redisTemplate.opsForList().rightPop("ss");
        Object ss = redisTemplate.opsForList().rightPop("ss");
        List ss1 = redisTemplate.opsForList().range("ss", 1, -1);
        System.out.println("ss1 = " + ss1);
    }

    @Test
    public void test02(){
        Date date = new Date(1613302877235L);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String format = f.format(date);
        System.out.println(format);
    }
}
