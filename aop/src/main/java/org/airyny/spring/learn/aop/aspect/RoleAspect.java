package org.airyny.spring.learn.aop.aspect;

import org.airyny.spring.learn.aop.aspect.model.Role;
import org.aspectj.lang.annotation.*;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/15 11:02
 * @Version:1.0
 * @deseription: 切面
execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))

 注意：
    1、”*“ 后用一个空格键隔开【*：代表人已返回类型的方法】
    2、execution：代表执行方法的时候会触发
    3、org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl：代表类的全限定名
    4、printRole：被拦截方法名称
    5、(..):任意的参数。

 <p>
AspectJ 指示器：

arg()：限制连接点匹配参数为指定类型的方法
@args()：限制而连接点匹配参数为指定注解标注的执行方法
execution：用于匹配连接点的执行方法，这是最常用的匹配，可以通过类似上面的正则表达式进行匹配
this(): 限制连接点匹配AOP 代理的Bean，引用为指定类型的类
target： 限制连接点匹配被代理对象为指定的类型
@target()： 限制连接点匹配特定的执行队形，这些对象要符合指定的注解类型
within() 限制连接点匹配指定的包
@within()：限制连接点匹配指定的类型
@annotation： 限定匹配带有指定注解的连接点

注意：Spring 只能支持以上的AspectJ 的指示器。使用了其他的指示器，它会排除IllegalArgumentException 异常
</p>
 **/
@Aspect
public class RoleAspect {


    //在被代理对象的方法前先调用
    @Before("execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))")
    public void before(){
        System.out.println("before----->>>>>在被代理对象的方法前先调用");
    }


    //在被代理对象的方法后调用
    @After("execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))"+
    "&& args(role)")
    public void after(Role role){
        System.out.println("after----->>>>>在被代理对象的方法后调用"+role.getName());
    }


    //在被代理对象的方法正常返回后调用
    @AfterReturning("execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))")
    public void afterReturning(){
        System.out.println("afterReturning----->>>>>在被代理对象的方法正常返回后调用");
    }


    //在被代理对象的方法抛出异常后调用
    @AfterThrowing("execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing----->>>>>在被代理对象的方法抛出异常后调用");
    }

    //将代理对象的方法封装起来，并用环绕通知取代它
    @Around("execution(* org.airyny.spring.learn.aop.aspect.server.RoleServiceImpl.printRole(..))")
    public void Around(){
        System.out.println("Around----->>>>>将代理对象的方法封装起来");
    }

}
