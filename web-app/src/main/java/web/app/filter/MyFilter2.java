package web.app.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/12 10:34
 * @Version:1.0
 * @deseription:
 **/
public class MyFilter2 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("########MyFilter2 doFilterInternal executed!!!#######");
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("#######MyFilter2 doFilter#####");

    }

    @Override
    public void destroy() {

    }


}
