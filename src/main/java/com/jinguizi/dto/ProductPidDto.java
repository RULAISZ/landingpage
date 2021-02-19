package com.jinguizi.dto;

import java.io.Serializable;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-02-18 17:44
 **/
public class ProductPidDto implements Serializable {
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
