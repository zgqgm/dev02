package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码集
        resp.setContentType("text/html; charset=UTF-8");
        // 获取session必须用false
        HttpSession session = req.getSession(false);
        if (session!=null){
            //获得id
            String id = session.getId();
            //删除键值对
            session.removeAttribute("username");
            resp.getWriter().append(id);
            // 销毁session
            session.invalidate();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
