package com.fc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(//通过annotation1/2/3都可以访问
        value = {"/annotation1", "/annotation2", "/annotation3"}, name = "annotation",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "name", value = "易烊千玺"),
                @WebInitParam(name = "age", value = "21"),
                @WebInitParam(name = "gender", value = "男")
        }
)
public class AnnotationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig servletConfig = getServletConfig();
        String name = servletConfig.getInitParameter("name");
        String age = servletConfig.getInitParameter("age");
        String gender = servletConfig.getInitParameter("gender");
        System.out.println(name + ":" + age + ":" + gender);
        System.out.println("注解方式，init被执行");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget执行");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
