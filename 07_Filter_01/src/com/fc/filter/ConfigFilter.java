package com.fc.filter;

import javax.servlet.*;
import java.io.IOException;

public class ConfigFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String username = filterConfig.getInitParameter("username");
        System.out.println("初始化参数：" + username);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("配置文件过滤器放行前");

        // 放行资源
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("配置文件过滤器放行后");
    }

    @Override
    public void destroy() {

    }
}
