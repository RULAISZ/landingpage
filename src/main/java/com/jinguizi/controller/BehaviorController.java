package com.jinguizi.controller;

import com.jinguizi.pojo.Behavior;
import com.jinguizi.pojo.Result;
import com.jinguizi.pojo.ResultCode;
import com.jinguizi.service.BehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 14:47
 **/
@RestController
@RequestMapping("jinguizi/behavior")
public class BehaviorController {

    @Autowired
    private BehaviorService behaviorService;

    /**
     * 添加和修改用户行为
     * @param behavior
     * @return
     */
    @PostMapping("saveBehavior")
    public Result saveBehavior(@RequestBody Behavior behavior){
        System.out.println(behavior);
        if (behavior==null||"0".equals(behavior.getFuid())){
            return Result.failure(ResultCode.ERROR_PARAMETER);
        }
        try {
            if (behavior.getFuid()==null||behavior.getFuid().length()==0){
                return Result.failure(ResultCode.ERROR_PARAMETER);
            }
            behaviorService.saveBehavior(behavior);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }
}
