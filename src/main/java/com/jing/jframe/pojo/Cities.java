package com.jing.jframe.pojo;

import java.util.List;

/**
 * Created by admin on 2016/6/5.
 */
public class Cities {
    private Province province;
    private List<City> cityList;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
