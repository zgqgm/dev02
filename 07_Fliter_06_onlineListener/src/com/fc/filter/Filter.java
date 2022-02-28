package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(value = "/*",initParams = {
        @WebInitParam(name = "characterEncoding",value = "UTF-8"),
        @WebInitParam(name = "contentType",value = "text/html; charset=UTF-8")
})
public class Filter implements javax.servlet.Filter {
    private String request = null;
    private String response = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        request = filterConfig.getInitParameter("characterEncoding");
        response = filterConfig.getInitParameter("contentType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding(request);
        resp.setContentType(response);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
