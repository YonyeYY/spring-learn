package org.airyny.spring.learn.transaction;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/22 9:47
 * @Version:1.0
 * @deseription:
 <p>
用Java 配置的方式来实现Spring 数据库事务，需要再配置类中实现接口TransactionManagementConfigurer 的
annotationDrivenTransactionManager 方法。Spring 会把annotationDrivenTransactionManager 方法
返回的事务管理器作为程序中的事务管理器
</p>
 **/
@Configuration
@ComponentScan
public class JavaTransactionConfig implements TransactionManagementConfigurer {

    private DataSource dataSource = null;

    /*
     * @method: initDataSource
     * @Author: xiang.yongye
     * 配置数据源
     *
     * @param  
     * @return javax.sql.DataSource 数据源
     */
    public DataSource initDataSource(){
        if (dataSource != null){
            return dataSource;
        }
        Properties props = new Properties();
        props.setProperty("driverClassName","com.mysql.jdbc.Driver");
        props.setProperty("url","jdbc:mysql://localhost:3306/airyny");
        props.setProperty("username","root");
        props.setProperty("password","root");
        props.setProperty("maxActive","200");
        props.setProperty("maxIdle","20");
        props.setProperty("maxWait","30000");
        try{
            dataSource = BasicDataSourceFactory.createDataSource(props);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }



    /**
     * @method: initjdbcTemplate
     * @Author: xiang.yongye
     * 配置jdbcTemplate
     * @param  
     * @return org.springframework.jdbc.core.JdbcTemplate
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate initjdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(initDataSource());
        return jdbcTemplate;
    }

    /*
     * @method: annotationDrivenTransactionManager
     * @Author: xiang.yongye
     * 实现接口方法，使得返回数据库事务管理器
     * @param  
     * @return org.springframework.transaction.PlatformTransactionManager
     */
    @Override
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        //设置事务管理器管理的数据源
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }
}
