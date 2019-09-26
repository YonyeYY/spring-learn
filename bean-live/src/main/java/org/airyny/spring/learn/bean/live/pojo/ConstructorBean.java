package org.airyny.spring.learn.bean.live.pojo;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/26 20:38
 * @Version:1.0
 * @deseription:
 **/
public class ConstructorBean {
    private String name;

    public ConstructorBean(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
