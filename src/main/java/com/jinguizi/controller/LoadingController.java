package com.jinguizi.controller;

import com.jinguizi.dto.RandomDto;
import com.jinguizi.pojo.Result;
import com.jinguizi.pojo.ResultCode;
import com.jinguizi.pojo.Template;
import com.jinguizi.service.LoadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 15:56
 **/
@RestController
@RequestMapping("jinguizi/loading")
public class LoadingController {

    @Autowired
    private LoadingService loadingService;

    /**
     * 随机查找一个落地页数据
     * @param randomDto
     * @return
     */
    @PostMapping("randomLoading")
    public Result randomLoading(@RequestBody RandomDto randomDto){
        if (randomDto.getKey()==null|| StringUtils.isEmpty(randomDto.getKey())){
            return Result.failure(ResultCode.ERROR_PARAMETER);
        }
        try {
            Template result = loadingService.randomLoading(randomDto.getKey());
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }
}
