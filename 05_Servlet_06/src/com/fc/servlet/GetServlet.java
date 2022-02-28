package com.fc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get")
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        // 获取上下文对象
        ServletContext servletContext = getServletContext();
        // 根据键获取对应的值
        Object username = servletContext.getAttribute("username");
        // 获取真实路径
        String realPath = servletContext.getRealPath("/");
        // 获取上下文路径：根路径
        String contextPath = servletContext.getContextPath();
        // 获取服务器信息：服务器名和版本号
        String serverInfo = servletContext.getServerInfo();
        resp.getWriter().print(username);
        resp.getWriter()
                .append("\r\n真实路径：\r\n")
                .append(realPath)
                .append("\r\n服务器信息：\n\n")
                .append(serverInfo)
                .append("\r\n根路径：\n\n")
                .append(contextPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
