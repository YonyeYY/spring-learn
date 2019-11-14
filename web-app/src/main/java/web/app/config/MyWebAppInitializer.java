package web.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/13 10:05
 * @Version:1.0
 * @deseription:
 **/
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Spring IoC 容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //可以返回Spring 的Java 配置文件数组
        return new Class[0];
    }


    //DisparcherServlet 的URI 映射关系配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //可以返回Spring 的Java 配置文件数组
        return new Class[0];
    }

    //DispatcherServlet 拦截内容
    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
