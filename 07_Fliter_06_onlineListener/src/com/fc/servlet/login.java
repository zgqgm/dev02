package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("小明")&&password.equals("123")){
            HttpSession session = req.getSession(true);
            session.setAttribute("username",username);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60*30);
            resp.addCookie(cookie);
            resp.sendRedirect("index");
        }else {
            resp.getWriter().write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
