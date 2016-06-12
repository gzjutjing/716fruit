package com.jing.commons;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jingjiong on 2016/5/31.
 */
public class GlobalUtils {
    /**
     * 将字符串两边加上num长度的-
     *
     * @param msg
     * @return
     */
    public static String logToLineInfo(String msg) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            sb.append("-");
        }
        return sb.toString() + msg + sb.toString();
    }

    /**
     * 将字符串两边加上num长度的-
     *
     * @param msg
     * @param num
     * @return
     */
    public static String logToLineInfo(String msg, int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        return sb.toString() + msg + sb.toString();
    }

    /**
     * 是不是手机
     *
     * @param phone
     * @return
     */
    public static boolean isMobilePhone(String phone) {
        if (org.apache.commons.lang3.StringUtils.isBlank(phone))
            return false;
        Pattern p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 判断是否是浮点数
     * @param num
     * @return
     */
    public static boolean isFloat(String num){
        if(StringUtils.isBlank(num))
            return false;
        Pattern p = Pattern.compile("^\\d+\\.\\d+$");
        Matcher m = p.matcher(num);
        return m.matches();
    }

}
