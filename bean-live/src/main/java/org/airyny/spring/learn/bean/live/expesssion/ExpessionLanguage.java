package org.airyny.spring.learn.bean.live.expesssion;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 15:23
 * @Version:1.0
 * @deseription:
 **/
public class ExpessionLanguage {

    private String name;
    private String note;

    public ExpessionLanguage(String name,String note){
        this.name=name;
        this.note=note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
