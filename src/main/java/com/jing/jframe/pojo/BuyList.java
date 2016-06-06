package com.jing.jframe.pojo;

import java.util.List;

/**
 * Created by admin on 2016/6/3.
 */
public class BuyList {
    //日，如2016-01-01
    private String date;
    private User user;
    private List<FruitDetail> detailList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FruitDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<FruitDetail> detailList) {
        this.detailList = detailList;
    }
}
