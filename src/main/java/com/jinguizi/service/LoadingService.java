package com.jinguizi.service;

import com.jinguizi.mapper.LoadingMapper;
import com.jinguizi.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 15:58
 **/
@Service
public class LoadingService {

    @Autowired
    private LoadingMapper loadingMapper;

    public Template randomLoading(String key) {
        //根据key查询模板数据
        List<Template> list = loadingMapper.findAllTemplateByKey(key);
        //判断是否为空
        if (list != null && list.size() > 0) {
            //生成随机数
            Random random = new Random();
            int index = random.nextInt(list.size());
            //获取随机模板
            Template result = list.get(index);
            return result;
        }
        return null;
    }
}
