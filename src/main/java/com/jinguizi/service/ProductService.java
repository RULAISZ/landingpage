package com.jinguizi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinguizi.dto.ProductDto;
import com.jinguizi.mapper.ProductMapper;
import com.jinguizi.pojo.Product;
import com.jinguizi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 16:45
 **/
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public void addProduct(Product product) {

        product.setKey(MD5Util.encodeByMd5(product.getPid()+product.getChannel()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = format.format(new Date());
        product.setCreateTime(createTime);
        productMapper.addProduct(product);
    }

    public PageInfo<Product> pageSearch(ProductDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<Product> list = productMapper.pageSearch(dto);
        PageInfo<Product> info = new PageInfo<>(list);
        return info;
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public void deleteProductById(Integer id) {
        productMapper.deleteProductById(id);
    }

    public void batchAddProduct(List<Product> list) {
        for (Product product : list) {
            product.setKey(MD5Util.encodeByMd5(product.getPid()+product.getChannel()));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(new Date());
            product.setCreateTime(createTime);
        }
        productMapper.addAllProduct(list);
    }

    public PageInfo<Map<String, Object>> findAllPid(ProductDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<Map<String,Object>> list = productMapper.findAllPid();
        PageInfo<Map<String, Object>> info = new PageInfo<>(list);
        return info;
    }

    public List<Product> findProductByPid(String pid) {
        List<Product> list = productMapper.findProductByPid(pid);
        return list;
    }
}
