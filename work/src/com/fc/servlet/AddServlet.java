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
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();
        // 准备一个用户对象
        UserInfo userInfo = objectMapper.readValue(parameter, UserInfo.class);
        //创建查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "insert into userinfo(name,age,gender,info) values(?,?,?,?)";
        int affection = 0;
        try {
            affection = queryRunner.update(connection, sql, userInfo.getName(), userInfo.getAge(), userInfo.getGender(), userInfo.getInfo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
         resp.getWriter().print(affection);
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }
}
