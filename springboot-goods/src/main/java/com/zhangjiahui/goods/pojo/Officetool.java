package com.zhangjiahui.goods.pojo;

import java.io.Serializable;
import java.util.Date;

public class Officetool implements Serializable {
    private static final long serialVersionUID = 4398473870366348813L;
    private Integer id;
    private String name;
    private String description;
    private Integer typeid;
    private Integer  price;
    private Integer num;
    private String createTime;
    private String supplier;
    private String username;


    public Officetool() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Officetool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", typeid=" + typeid +
                ", price=" + price +
                ", num=" + num +
                ", createTime=" + createTime +
                ", supplier='" + supplier + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
