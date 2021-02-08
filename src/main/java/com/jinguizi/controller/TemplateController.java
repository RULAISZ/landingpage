package com.jinguizi.controller;

import com.jinguizi.dto.SearchDto;
import com.jinguizi.dto.TemplateDto;
import com.jinguizi.mapper.ProductMapper;
import com.jinguizi.pojo.Product;
import com.jinguizi.pojo.Result;
import com.jinguizi.pojo.ResultCode;
import com.jinguizi.service.TemplateService;
import com.jinguizi.utils.FileUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 18:31
 **/
@RestController
@RequestMapping("jinguizi/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Value("${filepath}")
    private String filepath;

    @Value("${host}")
    private String host;

    /**
     * 图片上传
     * @param imgFile
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public Result upload(@RequestParam("img_file") MultipartFile imgFile) throws IOException {
        try {
            //获取原始文件名称
            String filename = imgFile.getOriginalFilename();
            //进行拼接
            filename = UUID.randomUUID().toString().replace("-","") + filename.substring(filename.lastIndexOf("."));
            FileUtil.approvalFile(imgFile, filename, filepath);
            return Result.success(host+"/"+filename);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    /**
     * 根据pid查询产品
     * @param dto
     * @return
     */
    @PostMapping("searchProduct")
    public Result searchProduct(@RequestBody SearchDto dto){
        try {
            List<Product> list = null;
            if (dto.getPid()!=null && StringUtils.isNotBlank(dto.getPid())){
                list = templateService.searchProduct(dto);
            }
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }


    /**
     * 添加模型
     * @param dto
     * @return
     */
    @PostMapping("addTemplate")
    public Result addTemplate(@RequestBody TemplateDto dto){
        try {
            if (dto.getName()==null|| StringUtils.isEmpty(dto.getName())){
                return Result.failure(ResultCode.ERROR_PARAMETER);
            }
            templateService.addTemplate(dto);
            List<Map<String, Object>> list = exportCsv(dto);
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    @Autowired
    private ProductMapper productMapper;

    private List<Map<String, Object>> exportCsv(TemplateDto dto){
        //根据pid查询产品
        List<Product> list = productMapper.findProductByPid(dto.getPid());
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        //遍历封装
        for (Product product : list) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("pid",product.getPid());
            map.put("name", product.getName());
            map.put("channel",product.getChannel());
            map.put("url",dto.getHost()+"/"+product.getId()+"/"+product.getKey());
            resultList.add(map);
        }
        //返回数据
        return resultList;

    }

}
