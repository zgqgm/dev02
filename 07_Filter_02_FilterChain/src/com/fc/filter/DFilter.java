package com.fc.filter;

import javax.servlet.*;
import java.io.IOException;
//过滤是按照部署描述符的filter-mapping元素出现的顺序执行的，即XML配置过滤器的有效路径
public class DFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("D过滤器放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("D过滤器放行后");
    }

    @Override
    public void destroy() {

    }
}
