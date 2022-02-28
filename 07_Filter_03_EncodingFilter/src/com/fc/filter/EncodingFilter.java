package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(value = "/*",initParams = {
        @WebInitParam(name = "characterEncoding",value = "UTF-8"),
        @WebInitParam(name = "contentType",value = "text/html; charset=UTF-8")
})
public class EncodingFilter implements Filter {
    private String characterEncoding;
    private String contentType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        characterEncoding=filterConfig.getInitParameter("characterEncoding");
        contentType=filterConfig.getInitParameter("contentType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强转为支持HTTP协议的请求和响应对象
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding(characterEncoding);
        resp.setContentType(contentType);
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
