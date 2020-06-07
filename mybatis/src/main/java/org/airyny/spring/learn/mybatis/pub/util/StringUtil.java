package org.airyny.spring.learn.mybatis.pub.util;

/**
 * @author xiang.yongye
 * @title: StringUtil
 * @description: TODO
 * @date 2020/3/16  10:41
 */
public class StringUtil {

    public static void main(String[] args){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("wwwww");
        stringBuffer.append(".jum");
        stringBuffer.append(".com");
        stringBuffer.insert(0,"hello");
        System.out.println(stringBuffer);
    }
}
