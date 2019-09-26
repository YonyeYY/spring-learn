package org.airyny.spring.learn.bean.live.pojo;

import org.springframework.beans.factory.DisposableBean;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/26 16:04
 * @Version:1.0
 * @deseription:
 **/
public class DisposableBeanImpl implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("调用接口DisposableBean 的destroy 方法");
    }
}
