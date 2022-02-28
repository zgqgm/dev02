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

@WebServlet("/codeLogin")
public class codeLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String username = req.getParameter("username");
        HttpSession codeSession = req.getSession(false);
        String codeValue=(String)codeSession.getAttribute("code");
        //查询运行器
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "select * from user where username = ?";
        User query = null;
        try {
             query = queryRunner.query(connection, sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (code.equals(codeValue) && query != null){
            //创建Session
            HttpSession session = req.getSession(true);
            // 将登录信息存储到session中
            session.setAttribute("user", query);
            //创建Cookie
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            Cookie cookie1 = new Cookie("user",username);
            //设置有效期
            cookie.setMaxAge(60*30);
            cookie1.setMaxAge(60*30);
            //将cookie发送到浏览器
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            //登录成功
            resp.getWriter().print("true");
            //销毁Session键
            req.getSession().removeAttribute("code");
        }else if (code.equals(codeValue)){
            resp.getWriter().print("11");
        }else {
            resp.getWriter().print("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
