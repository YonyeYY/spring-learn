package org.airyny.spring.learn.aop.xmlaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/18 16:07
 * @Version:1.0
 * @deseription:
 **/
@Service("xmlAspect")
public class XmlAspect {

    public void before(){
        System.out.println("before ....");
    }

    public void after(){
        System.out.println("after ....");
    }

    public void afterThrowing(){
        System.out.println("after-throwing ....");
    }

    public void afterReturning(){
        System.out.println("after-returning ....");
    }


    public void around(ProceedingJoinPoint jp){
        System.out.println("around before ....");
        try {
            jp.proceed();
        } catch(Throwable e){
            new RuntimeException("回调原有流程，产生异常。。。");
        }
        System.out.println("around ----->>end");
    }

}
