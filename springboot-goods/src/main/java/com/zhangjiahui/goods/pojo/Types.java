package com.zhangjiahui.goods.pojo;

import java.io.Serializable;

public class Types implements Serializable {
    private static final long serialVersionUID = -7431672717954927635L;
    private Integer tid;
    private String tname;

    public Types() {
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Types{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
