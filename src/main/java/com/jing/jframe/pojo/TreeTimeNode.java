package com.jing.jframe.pojo;

/**
 * Created by jingjiong on 2016/6/2.
 */
public class TreeTimeNode {
    public enum TimeTypeEnum {
        YEAR("YEAR"), MONTH("MONTH"), DAY("DAY");
        private String type;

        TimeTypeEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    //年或月或日名字
    private String name;
    private TimeTypeEnum type;//类型年或月或日

    public TreeTimeNode() {
    }

    public TreeTimeNode(String name, TimeTypeEnum type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeTypeEnum getType() {
        return type;
    }

    public void setType(TimeTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
