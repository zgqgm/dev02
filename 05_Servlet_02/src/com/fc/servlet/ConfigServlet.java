package com.fc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//配置方式是在WEB-INF 的web.xml里写初始化，（不建议这样写）

public class ConfigServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        ServletConfig servletConfig = getServletConfig();

        String name = servletConfig.getInitParameter("name");
        String age = servletConfig.getInitParameter("age");
        String gender = servletConfig.getInitParameter("gender");

        System.out.println(name + ":" + age + ":" + gender);


        System.out.println("配置文件，init被执行");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("等会下课干饭，酱香鸭腿，9块");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
