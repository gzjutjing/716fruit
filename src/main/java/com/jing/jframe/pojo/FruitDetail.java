package com.jing.jframe.pojo;

/**
 * Created by admin on 2016/6/3.
 */
public class FruitDetail {
    private String name;
    private Integer num;
    private Float price;
    private Boolean alipay;
    private Boolean weixinpay;
    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getAlipay() {
        return alipay;
    }

    public void setAlipay(Boolean alipay) {
        this.alipay = alipay;
    }

    public Boolean getWeixinpay() {
        return weixinpay;
    }

    public void setWeixinpay(Boolean weixinpay) {
        this.weixinpay = weixinpay;
    }
}
