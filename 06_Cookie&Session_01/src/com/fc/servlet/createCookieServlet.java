package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/createCookie")
public class createCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = "小天才";
        // URL编码
        String encode = URLEncoder.encode(name,"UTF-8");
        // 获取Cookie
        Cookie cookie = new Cookie("username",encode);
        // 整个项目中都有效果
        cookie.setPath("/");
        //其他服务器也有效
        //cookie.setDomain("*.baidu.com");
        // 设置有效期
        // 负数代表浏览器关闭时销毁
        //cookie.setMaxAge(-1);
        // 直接销毁Cookie
        //cookie.setMaxAge(0);
        // 60s秒后销毁
        cookie.setMaxAge(60);
        // 将Cookie发送到浏览器
        resp.addCookie(cookie);
        resp.getWriter().write("发送了一个Cookie");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
