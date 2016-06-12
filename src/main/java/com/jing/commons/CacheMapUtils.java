package com.jing.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jing.jframe.pojo.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/6/3.
 */
public class CacheMapUtils {
    private static Map<String, User> userCache = new HashMap<>();
    private static List<String> goodsUnitCache = new ArrayList<>();
    private static List<Province> provinceCache = new ArrayList<>();
    private static List<Cities> citiesCache = new ArrayList<>();
    private static List<Counties> countiesCache = new ArrayList<>();

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper o = new ObjectMapper();
        List<Province> provinceList = new ArrayList<>();
        Province p = new Province();
        p.setName("浙江省");
        provinceList.add(p);
        System.out.println(o.writeValueAsString(provinceList));

        List<City> cityList = new ArrayList<>();
        City c = new City();
        c.setName("杭州市");
        cityList.add(c);
        Cities cities = new Cities();
        cities.setCityList(cityList);
        cities.setProvince(p);
        System.out.println(o.writeValueAsString(cities));

        List<County> countyList = new ArrayList<>();
        String[] arr = {"上城区", "下城区", "江干区", "拱墅区", "西湖区", "滨江区", "萧山区", "余杭区", "桐庐县", "淳安县", "建德市", "富阳市", "临安市"};
        for (String s : arr) {
            County county = new County();
            county.setName(s);
            countyList.add(county);
        }
        Counties counties = new Counties();
        counties.setCountyList(countyList);
        counties.setCity(c);
        System.out.println(o.writeValueAsString(counties));
    }

    /**
     * 初始化省份信息
     */
    public static void initializeProvinceFromFile() {
        if (provinceCache.size() > 0)
            return;
        try {
            File provinceFile = new File(GlobalsConstants.SYSTEM_FOLDER_DIR + GlobalsConstants.PROVINCE_FILE_NAME);
            String strs = null;
            if (!provinceFile.exists()) {//不存在，初始化
                strs = GlobalsConstants.DEFAULT_PROVINCES_DATA;
                FileUtils.writeFile(provinceFile, GlobalsConstants.DEFAULT_PROVINCES_DATA);
            } else {
                strs = FileUtils.readFileToStr(provinceFile);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            List<Province> provinceList = objectMapper.readValue(strs, new TypeReference<List<Province>>() {
            });
            provinceCache.addAll(provinceList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Province> getProvinceCache() {
        return provinceCache;
    }

    /**
     * 初始化城市信息
     */
    public static void initializeCityFromFile() {
        if (citiesCache.size() > 0)
            return;
        try {
            File cityFile = new File(GlobalsConstants.SYSTEM_FOLDER_DIR + GlobalsConstants.CITY_FILE_NAME);
            String strs = null;
            if (!cityFile.exists()) {//不存在，初始化
                strs = GlobalsConstants.DEFAULT_CITIES_DATA;
                FileUtils.writeFile(cityFile, GlobalsConstants.DEFAULT_CITIES_DATA);
            } else {
                strs = FileUtils.readFileToStr(cityFile);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            List<Cities> citiesList = objectMapper.readValue(strs, new TypeReference<List<Cities>>() {
            });
            citiesCache.addAll(citiesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cities> getCitiesCache() {
        return citiesCache;
    }

    public static List<City> getCitiesByProvince(String province) {
        if (citiesCache.size() > 0) {
            for (Cities c : citiesCache) {
                if (c.getProvince().getName().equals(province)) {
                    return c.getCityList();
                }
            }
        }
        return null;
    }

    /**
     * 初始化乡镇信息
     */
    public static void initializeCountyFromFile() {
        if (countiesCache.size() > 0)
            return;
        try {
            File countyFile = new File(GlobalsConstants.SYSTEM_FOLDER_DIR + GlobalsConstants.COUNTY_FILE_NAME);
            String strs = null;
            if (!countyFile.exists()) {//不存在，初始化
                strs = GlobalsConstants.DEFAULT_COUNTIES_DATA;
                FileUtils.writeFile(countyFile, GlobalsConstants.DEFAULT_COUNTIES_DATA);
            } else {
                strs = FileUtils.readFileToStr(countyFile);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            List<Counties> countiesList = objectMapper.readValue(strs, new TypeReference<List<Counties>>() {
            });
            countiesCache.addAll(countiesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Counties> getCountiesCache() {
        return countiesCache;
    }

    public static List<County> getCountiesByCityName(String cityName) {
        if (countiesCache.size() > 0) {
            for (Counties c : countiesCache) {
                if (c.getCity().getName().equals(cityName)) {
                    return c.getCountyList();
                }
            }
        }
        return null;
    }

    /**
     * 读取用户资料文件，放入map缓存
     */
    public static void initializeUserFromFile() {
        if (userCache.size() == 0)
            return;
        File file = new File(GlobalsConstants.SYSTEM_FOLDER_DIR + GlobalsConstants.USER_DIR);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                try {
                    String temp = FileUtils.readFileToStr(f);
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<User> userList = objectMapper.readValue(temp, new TypeReference<List<User>>() {
                    });
                    for (User u : userList) {
                        userCache.put(u.getPhone(), u);
                    }
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据手机号码获取user对象
     *
     * @param phone
     * @return
     */
    public static User getUser(String phone) {
        return userCache.get(phone);
    }

    /**
     * 读取商品单位文件放入缓存
     */
    public static void initializeGoodsUnitFile() {
        if (goodsUnitCache.size() > 0)//防止jframe多次初始化重复读取
            return;
        File unitFile = new File(GlobalsConstants.SYSTEM_FOLDER_DIR + GlobalsConstants.DEFAULT_UNIT_FILE_NAME);
        String[] strs = null;
        try {
            if (!unitFile.exists()) {//不存在，用默认，且写文件
                strs = GlobalsConstants.GOODS_INITIAL_UNIT_NAMES.split(",");
                FileUtils.writeFile(unitFile, GlobalsConstants.GOODS_INITIAL_UNIT_NAMES);
            } else {//存在，读文件
                strs = FileUtils.readFileToStr(unitFile).split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (strs != null)
            for (String s : strs)
                goodsUnitCache.add(s);
    }

    /**
     * 获取商品单位
     *
     * @return
     */
    public static List<String> getGoodsUnitCache() {
        return goodsUnitCache;
    }
}
