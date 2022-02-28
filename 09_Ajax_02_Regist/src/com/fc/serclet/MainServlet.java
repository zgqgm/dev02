package com.fc.serclet;

import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //创建查询运行器
        QueryRunner queryRunner = new QueryRunner();
        //获取链接
        Connection connection = DruidUtil.getConnection();
        //Sql语句
        String sql = "insert into user(username, password) values(?,?)";
        int update = 0;
        try {
            update = queryRunner.update(connection, sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().print(update>0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
