package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String llf = req.getParameter("llf");//拿到删除记住用户信息的权限

        if (llf != null&&llf.equals("true")){//删除记住用户信息的Cookie
            //获得Cookie
            Cookie cookie2 = new Cookie("username","");
            Cookie cookie3 = new Cookie("password","");
            //删除Cookie
            cookie2.setMaxAge(0);
            cookie3.setMaxAge(0);
            //将Cookie发送给浏览器
            resp.addCookie(cookie2);
            resp.addCookie(cookie3);
        }else {
            //获得Session
            HttpSession session = req.getSession();
            //删除Session键值对
            session.removeAttribute("username");
            //获得Cookie
            Cookie cookie = new Cookie("JSESSIONID","");
            Cookie cookie1 = new Cookie("user","");
            //删除Cookie
            cookie.setMaxAge(0);
            cookie1.setMaxAge(0);
            //将Cookie发送给浏览器
            resp.addCookie(cookie1);
            resp.addCookie(cookie);
            resp.getWriter().print("true");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
