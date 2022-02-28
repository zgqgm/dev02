package com.sc.imports;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/impservlet")
public class ImplServlet implements Servlet {
    public ImplServlet() {
        System.out.println("无参构造只会在适用对象时执行一次");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法被执行一次");
    }

    @Override//获得服务配置
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override//中心方法
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务方法被执行");
    }

    @Override//获得服务信息
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {//停止服务器的时候执行
        System.out.println("销毁方法被执行");
    }
}
