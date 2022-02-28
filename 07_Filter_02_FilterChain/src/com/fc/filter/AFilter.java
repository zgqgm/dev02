package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")//配置注释写的过滤器执行顺序按自然顺序执行（ASCLL码值的顺序）
public class AFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A过滤器放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("A过滤器放行后");
    }

    @Override
    public void destroy() {

    }
}
