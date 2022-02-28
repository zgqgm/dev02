package com.fc.servlet;

import com.fc.bean.User;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "select * from user where username = ? and password = ?";
        User query = null;
        try {
            query = queryRunner.query(connection, sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (query != null){
            //创建Session
            HttpSession session = req.getSession(true);
            // 将登录信息存储到session中
            session.setAttribute("user", query);
            //创建Cookie
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            //设置有效期
            cookie.setMaxAge(60*30);
            //将cookie发送到浏览器
            resp.addCookie(cookie);
            //登录成功
            resp.sendRedirect("index");
        }else {
            //登录失败
            resp.sendRedirect("login.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
