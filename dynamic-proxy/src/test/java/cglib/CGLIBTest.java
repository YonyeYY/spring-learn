package cglib;

import org.airyny.spring.learn.dynamic.proxy.cglib.CglibBiz;
import org.airyny.spring.learn.dynamic.proxy.cglib.CglibProxyExample;
import org.junit.Test;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 10:50
 * @Version:1.0
 * @deseription:
 **/
public class CGLIBTest {


    @Test
    public void cglibTest(){
        CglibProxyExample cpe = new CglibProxyExample();
        CglibBiz obj = (CglibBiz)cpe.getProxy(CglibBiz.class);
        obj.cglibConnection("cglibConnection");
    }
}
