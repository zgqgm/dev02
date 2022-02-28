package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/create")
public class CreateSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个Session对象
        HttpSession session = req.getSession();
        //响应编码集
        resp.setContentType("text/html; charset=UTF-8");
        //获得ID
        String id = session.getId();
        //设置session键值对
        session.setAttribute("username","这是一个中文值");
        //创建一个Cookie对象
        Cookie cookie = new Cookie("JSESSIONID",id);
        //设置过期时间和session一致//这里有效期是一个小时
        cookie.setMaxAge(60*60);//设置有效期是为了关闭浏览器后下一次访问时Session的ID相同
        // 将cookie发送到浏览器
        resp.addCookie(cookie);
        resp.getWriter().print(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
