package responsibility;

import org.airyny.spring.learn.dynamic.proxy.responsibility.EmployeeImpl;
import org.airyny.spring.learn.dynamic.proxy.responsibility.EmployeeService;
import org.airyny.spring.learn.dynamic.proxy.responsibility.InterceptorJdkProxy;
import org.junit.Test;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/29 11:59
 * @Version:1.0
 * @deseription:
 **/
public class ResponsibilityTest {

    @Test
    public void responsibilityTest(){
        EmployeeService employeeService1 = (EmployeeService)InterceptorJdkProxy.bind(
                new EmployeeImpl(),
                "org.airyny.spring.learn.dynamic.proxy.responsibility.HumanResource");


        EmployeeService employeeService2 = (EmployeeService)InterceptorJdkProxy.bind(
                employeeService1,
                "org.airyny.spring.learn.dynamic.proxy.responsibility.DepartmentManager");

        EmployeeService employeeService3 = (EmployeeService)InterceptorJdkProxy.bind(
                employeeService2,
                "org.airyny.spring.learn.dynamic.proxy.responsibility.ProjectManager");

        employeeService3.getHoliday();

    }


}
