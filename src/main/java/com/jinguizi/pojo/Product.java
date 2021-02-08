package com.jinguizi.pojo;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 16:09
 **/
public class Product implements Serializable {
    private Integer id;
    @CsvBindByPosition(position = 2)
    private String pid;
    private String key;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 0)
    private String channel;
    @CsvBindByPosition(position = 3)
    private String apkUrl;
    @CsvBindByPosition(position = 4)
    private String iosUrl;
    private String createTime;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", channel='" + channel + '\'' +
                ", apkUrl='" + apkUrl + '\'' +
                ", iosUrl='" + iosUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(pid, product.pid) &&
                Objects.equals(key, product.key) &&
                Objects.equals(name, product.name) &&
                Objects.equals(channel, product.channel) &&
                Objects.equals(apkUrl, product.apkUrl) &&
                Objects.equals(iosUrl, product.iosUrl) &&
                Objects.equals(createTime, product.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, key, name, channel, apkUrl, iosUrl, createTime);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getIosUrl() {
        return iosUrl;
    }

    public void setIosUrl(String iosUrl) {
        this.iosUrl = iosUrl;
    }
}
