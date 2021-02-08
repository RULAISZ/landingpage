package com.jinguizi.service;

import com.jinguizi.dto.SearchDto;
import com.jinguizi.dto.TemplateDto;
import com.jinguizi.mapper.ProductMapper;
import com.jinguizi.mapper.TemplateMapper;
import com.jinguizi.pojo.Product;
import com.jinguizi.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 18:32
 **/
@Service
@Transactional
public class TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private ProductMapper productMapper;

    public void addTemplate(TemplateDto dto){
        /*List<Map<String, Object>> images = dto.getImages();
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> image : images) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",image.get("id"));
            map.put("type",image.get("type"));
            String androidUrl = (String) image.get("android_url");
            if (androidUrl==null){
                androidUrl = "";
            }
            map.put("android_url",androidUrl);
            String iosUrl = (String) image.get("ios_url");
            if (iosUrl==null){
                iosUrl = "";
            }
            map.put("ios_url",iosUrl);
            map.put("img_url",image.get("img_url"));
            list.add(map);
        }
        String content = JSON.toJSONString(list);*/
        Template template = new Template();
        template.setName(dto.getName());
        template.setPid(dto.getPid());
        template.setContent(dto.getContent());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.setCreateTime(format.format(new Date()));
        templateMapper.addTemplate(template);
    }

    public List<Product> searchProduct(SearchDto dto) {
        List<Product> list = productMapper.findProductByPid(dto.getPid());
        return list;
    }
}
