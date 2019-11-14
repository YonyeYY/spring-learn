package web.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/13 10:34
 * @Version:1.0
 * @deseription:
 **/
@Configuration
//定义扫描的包，加载控制器
@ComponentScan("web.app.*")
//启用Spring Web MVC
@EnableWebMvc
public class WebConfig {

    @Bean(name="viewResolver")
    public ViewResolver initViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
