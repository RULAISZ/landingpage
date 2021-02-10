package com.jinguizi.service;

import com.jinguizi.dto.RandomDto;
import com.jinguizi.mapper.LoadingMapper;
import com.jinguizi.mapper.ProductMapper;
import com.jinguizi.pojo.Product;
import com.jinguizi.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private ProductMapper productMapper;

    public Map<String, Object> randomLoading(RandomDto dto) {
        //根据key查询模板数据
        List<Template> list = loadingMapper.findAllTemplateByKey(dto.getKey());
        //判断是否为空
        if (list != null && list.size() > 0) {
            //生成随机数
            Random random = new Random();
            int index = random.nextInt(list.size());
            //获取随机模板
            Template template = list.get(index);

            Product product = productMapper.findProductById(dto.getProductId());

            HashMap<String, Object> result = new HashMap<>();

            result.put("id",template.getId());
            result.put("name",template.getName());
            result.put("content",template.getContent());
            result.put("pid",template.getPid());
            result.put("createTime",template.getCreateTime());
            result.put("apkUrl",product.getApkUrl());
            result.put("iosUrl",product.getIosUrl());

            return result;
        }
        return null;
    }
}
