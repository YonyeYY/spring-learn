package org.airyny.spring.learn.bean.live.beanfactory;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanFactoryMain {

    public static void main(String[] args){
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = (BeanFactory)bindViaCode(beanRegistry);
        DowJonesNewsListener newsListener = (DowJonesNewsListener)container.getBean("djListener") ;
        System.out.println(newsListener.getNewsLister());
        FXNewProviter djNewsProvider = (FXNewProviter)container.getBean("djNewsProvider") ;

    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewProviter.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

        //将bean 定义注册到容器中
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersister",newsPersister);

        //通过setter方法注入
        MutablePropertyValues propertyListenerValues = new MutablePropertyValues();
        propertyListenerValues.addPropertyValue(new PropertyValue("newsLister","你猜这个是个啥！！！"));
        newsListener.setPropertyValues(propertyListenerValues);
        //newsPersister
        MutablePropertyValues propertyPersisterValues = new MutablePropertyValues();
        propertyPersisterValues.addPropertyValue(new PropertyValue("newsPersister","你猜这个是个啥！！！"));
        newsPersister.setPropertyValues(propertyPersisterValues);

        //通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0,newsListener);
        argValues.addIndexedArgumentValue(1,newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);

        //通过setter方法注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister",newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        return (BeanFactory)registry;

    }







}
