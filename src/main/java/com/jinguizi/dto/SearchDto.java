package com.jinguizi.dto;

import java.io.Serializable;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-02 14:25
 **/
public class SearchDto implements Serializable {
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
