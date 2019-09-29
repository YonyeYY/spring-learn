package interceptor;

import org.airyny.spring.learn.dynamic.proxy.interceptor.InterceptorBiz;
import org.airyny.spring.learn.dynamic.proxy.interceptor.InterceptorJdkProxy;
import org.airyny.spring.learn.dynamic.proxy.interceptor.InterceptorService;
import org.junit.Test;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:17
 * @Version:1.0
 * @deseription:
 **/
public class InterceptorTest {

    @Test
    public void interceptorTest(){
        InterceptorService proxy = (InterceptorService) InterceptorJdkProxy.bind(
                new InterceptorBiz(),
                "org.airyny.spring.learn.dynamic.proxy.interceptor.MyInterceptor");

        proxy.agencyConnection();
    }


}
