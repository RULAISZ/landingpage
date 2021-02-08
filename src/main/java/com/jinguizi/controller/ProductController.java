package com.jinguizi.controller;

import cn.hutool.core.util.CharsetUtil;
import com.github.pagehelper.PageInfo;
import com.jinguizi.dto.ProductDelDto;
import com.jinguizi.dto.ProductDto;
import com.jinguizi.pojo.Product;
import com.jinguizi.pojo.Result;
import com.jinguizi.pojo.ResultCode;
import com.jinguizi.service.ProductService;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 16:42
 **/
@RestController
@RequestMapping("jinguizi/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 批量添加产品数据
     * @param uploadFile
     * @return
     */
    @PostMapping("batchAddProduct")
    public Result batchAddProduct(@RequestParam("upload_file") MultipartFile uploadFile) {
        try {
            if (uploadFile.isEmpty()) {
                return Result.failure(ResultCode.ERROR_UPLOAD_EMPTY);
            }
            String originalFilename = uploadFile.getOriginalFilename();
            String[] split = originalFilename.split("\\.");
            if (!"csv".equals(split[split.length-1])){
                return Result.failure(ResultCode.ERROR_UPLOAD_TYPE);
            }
            InputStreamReader inputStream = new InputStreamReader(uploadFile.getInputStream(), CharsetUtil.CHARSET_GBK);
            // 设置解析策略，使用@CsvBindByPosition注解可以指定字段在csv文件头中的位置，从0开始
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Product.class);

            CsvToBean csvToBean = new CsvToBeanBuilder(inputStream)
                    .withMappingStrategy(strategy)
                    .build();
            List list = csvToBean.parse();
            //System.out.println("list = " + list);
            productService.batchAddProduct(list);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    /**
     * 添加产品
     * @param product
     * @return
     */
    @PostMapping("addProduct")
    public Result addProduct(@RequestBody Product product){
        try {
            productService.addProduct(product);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */
    @PostMapping("pageSearch")
    public Result pageSearchProduct(@RequestBody ProductDto dto){
        try {
            if (dto.getPageNum()==null||dto.getPageNum()<=0){
                dto.setPageNum(1);
            }
            if (dto.getPageSize()==null||dto.getPageSize()<=0){
                dto.setPageSize(10);
            }
            PageInfo<Product> list = productService.pageSearch(dto);
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    /**
     * 修改产品
     * @param product
     * @return
     */
    @PostMapping("updateProduct")
    public Result updateProduct(@RequestBody Product product){
        try {
            if (product.getId()==null||product.getId()<0){
                return Result.failure(ResultCode.ERROR_PARAMETER);
            }
            productService.updateProduct(product);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }

    /**
     * 删除产品
     * @param dto
     * @return
     */
    @PostMapping("deleteProduct")
    public Result deleteProduct(ProductDelDto dto){
        try {
            if (dto.getId()==null||dto.getId()<0){
                return Result.failure(ResultCode.ERROR_PARAMETER);
            }
            productService.deleteProductById(dto.getId());
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(ResultCode.FAIL);
        }
    }
}
