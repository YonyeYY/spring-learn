package org.airyny.spring.learn.dynamic.proxy.responsibility;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 12:01
 * @Version:1.0
 * @deseription:
 **/
public class EmployeeImpl implements EmployeeService {
    @Override
    public void getHoliday() {
        System.out.println("请假申请=====>>>>>>>>>>>>");
        System.err.println();
    }
}
