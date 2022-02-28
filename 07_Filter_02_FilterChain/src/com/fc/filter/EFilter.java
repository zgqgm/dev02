package com.fc.filter;

import javax.servlet.*;
import java.io.IOException;

public class EFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("E过滤器放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("E过滤器放行后");
    }

    @Override
    public void destroy() {

    }
}
