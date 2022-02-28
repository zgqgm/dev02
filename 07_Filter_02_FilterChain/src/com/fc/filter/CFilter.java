package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class CFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("C过滤器放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("C过滤器放行后");
    }

    @Override
    public void destroy() {

    }
}
