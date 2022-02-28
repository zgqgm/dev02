package com.fc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// value属性就是请求的路径
// loadOnStartup对应启动时加载
@WebServlet(value = "/life", loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "name1", value = "文青"),
                @WebInitParam(name = "name2", value = "玉起"),
                @WebInitParam(name = "name3", value = "熊大"),
                @WebInitParam(name = "name4", value = "吉吉国王"),
                @WebInitParam(name = "name5", value = "毛毛")
        })
public class LifeServlet implements Servlet {
    public LifeServlet() {
        System.out.println("构造方法被执行");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法被执行");
        String name1 = servletConfig.getInitParameter("name1");//获取初始化参数
        String name2 = servletConfig.getInitParameter("name2");
        String name3 = servletConfig.getInitParameter("name3");
        String name4 = servletConfig.getInitParameter("name4");
        String name5 = servletConfig.getInitParameter("name5");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println(name5);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法被执行...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法被执行...");
    }
}
