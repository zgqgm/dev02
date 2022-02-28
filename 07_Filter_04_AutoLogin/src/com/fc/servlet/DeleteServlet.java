package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session
        HttpSession session = req.getSession(false);
        session.removeAttribute("user");
        //session.invalidate();
        Cookie cookie = new Cookie("JSESSIONID", "");
        // 销毁Cookie
        cookie.setMaxAge(0);
        // 发送到浏览器
        resp.addCookie(cookie);
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
