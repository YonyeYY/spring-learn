package org.airyny.spring.learn.aop.xmlaspect.model;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 16:09
 * @Version:1.0
 * @deseription:
 **/
public class Role {
    private String name;
    private String sex;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
