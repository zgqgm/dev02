package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.UserInfo;
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

@WebServlet("/upData")
public class UpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        resp.setContentType("text/json; charset=UTF-8");
        String parameter = req.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();
        // 准备一个用户对象
        UserInfo userInfo = objectMapper.readValue(parameter, UserInfo.class);
        //创建查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "update userinfo set name = ?, age = ?, gender = ?, info = ? where id = ?";
        int affectedRows = 0;

        try {
            affectedRows = queryRunner.update(connection, sql, userInfo.getName(), userInfo.getAge(), userInfo.getGender(), userInfo.getInfo(), userInfo.getId());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        resp.getWriter().print(affectedRows);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
