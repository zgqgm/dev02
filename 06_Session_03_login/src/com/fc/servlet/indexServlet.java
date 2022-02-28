package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        resp.setContentType("text/html; charset=UTF-8");
        //获得Session
        HttpSession session = req.getSession(false);
        // 如果说session为空，说明没有登录
        if (session == null || session.getAttribute("username") == null){
            resp.getWriter().write("请重新登录");
            resp.sendRedirect("login.html");
        }else {
            resp.getWriter().write("<h5 Style='color:green' align='center'>欢迎" +
                            session.getAttribute("username")+
                    "登录</h5><h5 align='center'><a href='out'>退出登录</a></h5>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
