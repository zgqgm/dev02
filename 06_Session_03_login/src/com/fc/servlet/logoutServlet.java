package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/out")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得Session
        HttpSession session = req.getSession();
        //删除Session键值对
        session.removeAttribute("username");
        //获得Cookie
        Cookie cookie = new Cookie("JSESSIONID","");
        //删除Cookie
        cookie.setMaxAge(0);
        //将Cookie发送给浏览器
        resp.addCookie(cookie);
        //重定向到首页
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
