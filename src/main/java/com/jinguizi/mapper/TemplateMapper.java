package com.jinguizi.mapper;

import com.jinguizi.pojo.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateMapper {

    void addTemplate(Template template);

    List<Template> findAllTemplate();

    void deleteTemplateById(Integer id);
}
