package com.jing.commons;

import java.io.*;

/**
 * Created by admin on 2016/6/12.
 */
public class FileUtils {


    /**
     * 读取文件，转化为string
     */
    public static String readFileToStr(File file) throws IOException {
        if (!file.exists())
            return null;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String temp = null;
        StringBuilder sb = new StringBuilder();
        while ((temp = reader.readLine()) != null) {
            sb.append(temp);
        }
        reader.close();
        return sb.toString().replaceAll("\\r\\n", "");
    }

    /**
     * 写文件
     */
    public static void writeFile(File file, String content) throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(content);
        writer.flush();
        writer.close();
    }

}
