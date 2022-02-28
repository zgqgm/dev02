package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/getCode")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        //判断是否在六十秒内获取过
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")){
                    resp.getWriter().write("请60s之后再次获取");
                    return;
                }
            }

        }
        //获得6位随机数
        String value=Integer.toString((int)((Math.random()*9+1)*100000));
        //创建Session;
        HttpSession session = req.getSession(true);
        //创建Session键值对
        session.setAttribute("code",value);
        //创建Cookie
        Cookie cookie = new Cookie("time",value);
        //销毁
        cookie.setMaxAge(60);
        session.setMaxInactiveInterval(60);
        //将Cookie添加到前端
        resp.addCookie(cookie);
        resp.getWriter().print(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
