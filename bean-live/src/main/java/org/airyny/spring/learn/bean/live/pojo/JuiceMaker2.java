package org.airyny.spring.learn.bean.live.pojo;



import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/26 16:05
 * @Version:1.0
 * @deseription:
 **/
public class JuiceMaker2 implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean {

    private String beverageShop = null;
    private Source source = null;

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void init(){
        System.out.println(this.getClass().getSimpleName()+'\t'+"执行自定义初始化方法");
    }
    public void destory(){
        System.out.println(this.getClass().getSimpleName()+'\t'+"执行自定义销毁方法");
    }


    public String makeJuice(){
        String juice = "这是一杯由"+beverageShop +"饮品店，提供的"
                +source.getSize()+source.getSugar()+source.getFruit();
        return juice;
    }



        @Override
    public void setBeanName(String name) {
            System.out.println(this.getClass().getSimpleName()+"调用BeanNameAware 接口的setBeanName 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getSimpleName()+"调用BeanFactoryAware setBeanFactory 方法");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName()+"调用InitializingBean 接口afterPropertiesSet方法");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getSimpleName()+"调用ApplicationContextAware接口setApplicationContext方法");

    }
}
