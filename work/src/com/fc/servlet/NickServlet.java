package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.PUserInfo;
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

@WebServlet("/nick")
public class NickServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");
        String parameter = req.getParameter("data");
        System.out.println(parameter);
        ObjectMapper objectMapper = new ObjectMapper();
        // 准备一个用户对象
        PUserInfo pUserInfo = objectMapper.readValue(parameter, PUserInfo.class);
        //创建查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接对象
        Connection connection = DruidUtil.getConnection();
        System.out.println(pUserInfo.getBirthday());
        //sql语句
        String sql = "update user_info set nickname = ?, signature = ?, gender = ?, birthday = ? where id = ?";
        int affectedRows = 0;

        try {
            affectedRows = queryRunner.update(connection, sql, pUserInfo.getNickname(),pUserInfo.getSignature(), pUserInfo.getGender(), pUserInfo.getBirthday(), pUserInfo.getId());
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
