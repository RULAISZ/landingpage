package com.jinguizi.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-09 09:25
 **/
public class DelTemplateDto implements Serializable {
    private Integer id;

    @Override
    public String toString() {
        return "DelTemplateDto{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelTemplateDto that = (DelTemplateDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
