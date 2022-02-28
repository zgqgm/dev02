package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获得请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 只有当用户名和密码都正确才能进行跳转
        if(username.equals("小明")&&password.equals("123456")){
            // 请求当前项目资源
            // resp.sendRedirect("redirect.html");

            // 请求网络资源
            resp.sendRedirect("https://www.mi.com");
        }else {
            resp.getWriter().write("登录失败");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
