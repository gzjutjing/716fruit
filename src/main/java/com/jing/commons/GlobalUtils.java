package com.jing.commons;

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
    public static String toLineInfo(String msg) {
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
    public static String toLineInfo(String msg, int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        return sb.toString() + msg + sb.toString();
    }
}
