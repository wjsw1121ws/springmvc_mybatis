package com.cc.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @ClassName: Items
 * @Auther: changchun_wu
 * @Date: 2018/11/27 23:17
 * @Version: 1.0
 **/
public class Items implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String detail;
    private String pic;
    private Date createtime;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
