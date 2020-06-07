package org.airyny.spring.learn.mybatis.pub.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiang.yongye
 * @title: Target
 * @description: TODO
 * @date 2020/3/13  15:33
 */
public class Target {

    @IFaceProperty(desc = "c1",required = true)
    private String name;

    @IFaceProperty(desc = "c2",required = true)
    private Date date;

    @IFaceProperty(desc = "c3",required = true)
    private Long longd;

    @IFaceProperty(desc = "c4",required = true)
    private BigDecimal bigDecimal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLongd() {
        return longd;
    }

    public void setLongd(Long longd) {
        this.longd = longd;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", longd=" + longd +
                ", bigDecimal=" + bigDecimal +
                '}';
    }
}
