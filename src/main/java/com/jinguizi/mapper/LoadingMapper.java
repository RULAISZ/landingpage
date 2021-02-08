package com.jinguizi.mapper;

import com.jinguizi.pojo.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoadingMapper {

    List<Template> findAllTemplateByKey(String key);
}
