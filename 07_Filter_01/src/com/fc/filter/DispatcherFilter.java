package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD})
public class DispatcherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("转发放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("转发放行后");
    }

    @Override
    public void destroy() {

    }
}
