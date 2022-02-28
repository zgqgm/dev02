package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*", initParams = {
        @WebInitParam(name = "username", value = "玛卡巴卡"),
        @WebInitParam(name = "password", value = "123")
})
public class FirstFilter implements Filter {
    public FirstFilter() {
        System.out.println("服务器启动，构造方法被执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("构造方法执行后，初始化方法被执行");
        String username = filterConfig.getInitParameter("username");
        String password = filterConfig.getInitParameter("password");
        System.out.println(username+":"+password);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器放行前");
        //将传过来的请求参数强转为HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取URL中的路径
        StringBuffer requestURL = request.getRequestURL();
        // 如果访问的资源是以HTML结尾的
        //if (requestURL.endsWith(".html")) {
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        //}

        // 必须对指定的资源进行放行
        // 放行

        System.out.println("过滤器放行后");
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器，关闭服务器时执行");
    }
}
