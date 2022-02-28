package com.fc.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")//doget和dopost可以互调，也可以不调用（平常建议下面写法）
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        System.out.println("真棒！！！！");
        resp.getWriter().println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doGet(req, resp);
    }
    /**
     *  @Override
     *     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     *         System.out.println("get方法被执行");
     *     }
     *
     *     @Override
     *     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     *         System.out.println("post方法被执行");
     *     }
     */

}
