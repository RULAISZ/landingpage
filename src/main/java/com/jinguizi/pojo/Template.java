package com.jinguizi.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 16:10
 **/
public class Template implements Serializable {
    private Integer id;
    private String name;
    private String content;
    private String pid;
    private String createTime;

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", pid='" + pid + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(id, template.id) &&
                Objects.equals(name, template.name) &&
                Objects.equals(content, template.content) &&
                Objects.equals(pid, template.pid) &&
                Objects.equals(createTime, template.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, pid, createTime);
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
