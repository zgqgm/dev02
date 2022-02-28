package com.fc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//获取服务器上下文对象
@WebServlet("/getServletContext")
public class GetServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过请求对象获取上下文对象
        ServletContext servletContext1= req.getServletContext();
        // 通过HttpServlet获取上下文对象
        ServletContext servletContext2= getServletContext();
        // 通过配置对象获取上下文对象
        ServletContext servletContext3= getServletConfig().getServletContext();
        // 通过session来获取上下文对象
        ServletContext servletContext4 = req.getSession().getServletContext();
        System.out.println(servletContext1 == servletContext2);
        System.out.println(servletContext2 == servletContext3);
        System.out.println(servletContext3 == servletContext4);//这四个是同一个对象
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
