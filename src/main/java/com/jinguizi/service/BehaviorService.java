package com.jinguizi.service;

import com.jinguizi.mapper.BehaviorMapper;
import com.jinguizi.pojo.Behavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 14:51
 **/
@Service
@Transactional
public class BehaviorService {

    @Autowired
    private BehaviorMapper behaviorMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public void insertBehavior(Behavior behavior) {
        //数据初始化
        behavior.setIsClickBanner(0);
        behavior.setIsClickEggs(0);
        behavior.setIsClickEggsRedpack(0);
        behavior.setIsClickEggsRedpackClose(0);
        behavior.setIsClickPrimaryDownload(0);
        behavior.setIsClickRedpack(0);
        behavior.setIsClickRedpackClose(0);
        behavior.setIsClickTurn(0);
        behavior.setIsClickTurnGift(0);
        behavior.setIsClickTurnGiftClose(0);
        behavior.setIsScroll(0);
        behavior.setStartToEndTime(0L);
        behavior.setTriggerEggNum(0);
        behavior.setTriggerTurnNum(0);
        behavior.setIsClickEggsClose(0);
        behavior.setIsClickTurnClose(0);
        if (behavior.getInmarsatSerialNumber()==null||behavior.getInmarsatSerialNumber().length()==0){
            behavior.setInmarsatSerialNumber("");
        }
        if (behavior.getMobileType()==null||behavior.getMobileType().length()==0){
            behavior.setMobileType("");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        behavior.setCreateTime(format.format(new Date()));
        behaviorMapper.insertBehavior(behavior);
    }

    public void updateBehavior(Behavior behavior) {
        behaviorMapper.updateBehavior(behavior);
    }

    public void saveBehavior(Behavior behavior) {
        Integer count = behaviorMapper.findBehaviorCount(behavior);
        if (count>0){
            //redisTemplate.opsForList().leftPush("jinguizi", JSON.toJSONString(behavior));
            updateBehavior(behavior);
        }else{
            insertBehavior(behavior);
        }
    }
}
