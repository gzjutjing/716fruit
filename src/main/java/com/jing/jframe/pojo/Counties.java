package com.jing.jframe.pojo;

import java.util.List;

/**
 * Created by admin on 2016/6/5.
 */
public class Counties {
    private City city;
    private List<County> countyList;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<County> getCountyList() {
        return countyList;
    }

    public void setCountyList(List<County> countyList) {
        this.countyList = countyList;
    }
}
