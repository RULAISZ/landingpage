package com.jinguizi.mapper;

import com.jinguizi.pojo.Template;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TemplateMapper {

    void addTemplate(Template template);
}
