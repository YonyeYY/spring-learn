package org.airyny.spring.learn.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/22 10:15
 * @Version:1.0
 * @deseription:
 **/
public class TransactionForCode {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        //事务定义类
        TransactionDefinition def = new DefaultTransactionDefinition();
        PlatformTransactionManager  transactionManager = ctx.getBean(PlatformTransactionManager.class);

        TransactionStatus status = transactionManager.getTransaction(def);
        try{
            //执行SQL 语句
            jdbcTemplate.update("insert into sys_userinfo(id,user_name)"
            +"values('222','小丸子哇！！！')");
            //提交事务
            transactionManager.commit(status);
        }catch(Exception ex){
            //回滚事务
            transactionManager.rollback(status);
        }
    }
}
