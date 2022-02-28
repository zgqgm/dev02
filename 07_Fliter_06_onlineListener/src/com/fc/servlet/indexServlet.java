package com.fc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class indexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        int num=0;
        Object cont1 = servletContext.getAttribute("cont");
        if(cont1 != null){
            num = (int)cont1;
        }
        resp.getWriter().print("<h1 align='center'>当前的在线人数为：" + num + "</h1>" +
                "<h1 align='center'><a href='logout'>退出登录</a></h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
