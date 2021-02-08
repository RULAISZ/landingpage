package com.jinguizi.task;

import com.jinguizi.pojo.Behavior;
import com.jinguizi.service.BehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

//@Component
public class BehaviorTask {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BehaviorService behaviorService;

    @Scheduled(fixedRate = 5000)
    public void testTaskFirst() {
        System.out.println("定时任务:每五秒执行一次，当前时间："+ LocalTime.now());
        for (int i = 0; i < 500; i++) {
            Behavior behavior = (Behavior) redisTemplate.opsForList().rightPop("jinguizi");
            if (behavior==null){
                break;
            }
            behaviorService.updateBehavior(behavior);
        }
    }
 
    /*@Scheduled(cron = "0 28 03 ? * *")
    public void testTaskSecond() {
        System.out.println("定时任务二:指定每天3:26执行，当前时间："+LocalTime.now());
    }*/
}