package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取请求中的路径部分
        String requestURI = request.getRequestURI();
        // 获取session
        HttpSession session = request.getSession(false);
        // 登录相关的资源一定要进行放行
        if (requestURI.endsWith("login.html") || requestURI.endsWith("login")) {
            filterChain.doFilter(request, response);
        } else if (session == null || session.getAttribute("user") == null) {
            // 没有登录
            response.sendRedirect("login.html");
        } else {
            // 已经登录
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
