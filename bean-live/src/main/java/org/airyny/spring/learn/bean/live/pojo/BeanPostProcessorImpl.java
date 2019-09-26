package org.airyny.spring.learn.bean.live.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/26 16:00
 * @Version:1.0
 * @deseription:
 **/
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("["+bean.getClass().getSimpleName()+"]"+beanName+"开始实例化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("["+bean.getClass().getSimpleName()+"]"+beanName+"实例化完成");

        return bean;
    }
}
