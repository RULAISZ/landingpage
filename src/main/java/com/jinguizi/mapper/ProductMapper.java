package com.jinguizi.mapper;

import com.jinguizi.dto.ProductDto;
import com.jinguizi.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    void addProduct(Product product);

    List<Product> pageSearch(ProductDto dto);

    void updateProduct(Product product);

    void deleteProductById(Integer id);

    Product findProductByKey(String key);

    List<Product> findProductByPid(String pid);

    void addAllProduct(List<Product> list);

    Product findProductById(Integer productId);

    List<Map<String, Object>> findAllPid();

}
