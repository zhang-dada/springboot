package com.zhangjiahui.goods.pojo;

import java.util.Date;

public class OfficetoolVo extends Officetool{
    private Integer tid;
    private String tname;

    //日期区间
    private String startTime;
    private String endTime;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "OfficetoolVo{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
