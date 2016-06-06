package com.jing.commons;

/**
 * 系统常林类
 * Created by jingjiong on 2016/5/31.
 */
public class GlobalsConstants {
    //扫描包路径
    public static final String SCAN_BASE_PACKAGE = "com.jing";

    //系统所有数据都放文件夹
    public static final String SYSTEM_FOLDER_DIR = "C:/fruit/";
    //放用户数据的目录
    public static final String USER_DIR = SYSTEM_FOLDER_DIR + "users/";
    public static final String USER_FILE_NAME = "user";

    //商品默认单位
    public static final String GOODS_INITIAL_UNIT_NAMES = "个,斤,盒,颗,篮,瓶,听,杯,串,打";
    public static final String DEFAULT_UNIT_FILE_NAME = "unit.txt";

    //默认省市区
    public static final String DEFAULT_PROVINCES_DATA = "[{\"name\":\"浙江省\",\"code\":null}]";
    public static final String DEFAULT_CITIES_DATA = "[{\"province\":{\"name\":\"浙江省\",\"code\":null},\"cityList\":[{\"name\":\"杭州市\",\"code\":null}]}]";
    public static final String DEFAULT_COUNTIES_DATA = "[{\"city\":{\"name\":\"杭州市\",\"code\":null},\"countyList\":[{\"name\":\"上城区\",\"code\":null},{\"name\":\"下城区\",\"code\":null},{\"name\":\"江干区\",\"code\":null},{\"name\":\"拱墅区\",\"code\":null},{\"name\":\"西湖区\",\"code\":null},{\"name\":\"滨江区\",\"code\":null},{\"name\":\"萧山区\",\"code\":null},{\"name\":\"余杭区\",\"code\":null},{\"name\":\"桐庐县\",\"code\":null},{\"name\":\"淳安县\",\"code\":null},{\"name\":\"建德市\",\"code\":null},{\"name\":\"富阳市\",\"code\":null},{\"name\":\"临安市\",\"code\":null}]}]";

    public static final String PROVINCE_FILE_NAME = "province.txt";
    public static final String CITY_FILE_NAME = "city.txt";
    public static final String COUNTY_FILE_NAME = "county.txt";

}
