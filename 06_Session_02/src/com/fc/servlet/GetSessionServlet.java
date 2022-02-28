package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/get")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码集
        resp.setContentType("text/html; charset=UTF-8");
        // 获取session必须用false
        HttpSession session = req.getSession(false);
        if (session != null){
            //获得id
            String id = session.getId();
            // 获取最后一次访问的时间戳
            long lastAccessedTime = session.getLastAccessedTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = simpleDateFormat.format(lastAccessedTime);
            // 获取失效时间【1800】单位是秒：单个钟头30分钟
            int maxInactiveInterval = session.getMaxInactiveInterval();
            System.out.println("失效时间：" + maxInactiveInterval);
            session.setMaxInactiveInterval(3600);
            System.out.println("失效时间：" + session.getMaxInactiveInterval());
            //获得键值对值
            String username = (String)session.getAttribute("username");
            resp.getWriter()
                    .append(id)
                    .append("最后一次访问的时间：")
                    .append(dateTime)
                    .append("session中的键值对：")
                    .append(username);

            return;
        }
        resp.getWriter().append("session为空");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
