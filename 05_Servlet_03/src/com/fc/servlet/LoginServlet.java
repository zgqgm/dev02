package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码集
        req.setCharacterEncoding("UTF-8");
        //设置响应编码集
        resp.setContentType("text/html;charset=UTF-8");
        // 从前端获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+":"+password);
        if (username.equals("姐不狂但拽") && password.equals("123456789")) {
            resp.getWriter().write("欢迎来自130圣光守护区的荣耀青铜玩家登录成功");
        } else {
            resp.getWriter().write("账号或者密码错误，登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
