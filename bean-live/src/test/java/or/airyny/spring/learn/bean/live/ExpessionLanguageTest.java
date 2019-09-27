package or.airyny.spring.learn.bean.live;

import java.util.ArrayList;
import java.util.List;

import org.airyny.spring.learn.bean.live.expesssion.ElBean;
import org.airyny.spring.learn.bean.live.expesssion.ExpessionLanguage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 15:24
 * @Version:1.0
 * @deseription:
 **/
public class ExpessionLanguageTest {
    //表达式解析器
    ExpressionParser parser = new SpelExpressionParser();

    //设置表达式
    Expression exp;

    @Test
    public void elTest(){
        exp =parser.parseExpression("'Hello world!!!!'");
        String str = (String) exp.getValue();
        System.out.println(str);

        //通过EL 访问普通方法
        exp = parser.parseExpression("'hello world'.charAt(0)");
        char ch = (Character) exp.getValue();
        System.out.println(ch);

        //通过EL 访问getter 方法
        exp = parser.parseExpression("'hello world'.bytes");
        byte[] bytes=(byte[]) exp.getValue();
        System.out.println(bytes);

        //通过EL访问的属性，相当于“hello world".getBytes().length
        exp = parser.parseExpression("'hello world'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);
        exp = parser.parseExpression("new String('asdf')");
        String abc = (String) exp.getValue();
        System.out.println(abc);

    }

    @Test
    public void elObjectTest(){

        //创建角色对象
        ExpessionLanguage el = new ExpessionLanguage("name","note");
        exp = parser.parseExpression("note");

        //相当于role 中获取备注信息
        String note = (String) exp.getValue(el);
        System.out.println(note);

        //变量环境类，并且将角色对象role 作为其根节点
        EvaluationContext ctx = new StandardEvaluationContext(el);

        //变量环境类操作根节点
        parser.parseExpression("note").setValue(ctx,"new_note");

        //获取备注，这里的String.class 指明，我们希望返回的是一个字符串
        note = parser.parseExpression("note").getValue(ctx,String.class);
        System.out.println(note);

        //调用getRoleName 方法
        String roleName = parser.parseExpression("getName()").getValue(ctx,String.class);
        System.out.println(roleName);

        //新增环境变量
        List<String> list = new ArrayList<String>();
        list.add("value1");
        list.add("value2");

        //给变量环境增加变量
        ctx.setVariable("list",list);

        //通过表达式佢读/写环境变量的值
        parser.parseExpression("#list[1]").setValue(ctx,"update_value2");
        System.out.println(parser.parseExpression("#list[1]").getValue(ctx));


    }


    @Test
    public void elObjectInit(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-el-context.xml");

        ElBean elBean = (ElBean) context.getBean("elBean");
        System.out.println(elBean.toString());

    }








}
