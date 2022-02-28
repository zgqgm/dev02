package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.UserInfo;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");
        //获取参数
        String param = req.getParameter("id");
        int id = Integer.parseInt(param);
        //获得查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        //sql
        String sql = "select * from userinfo where id = ?";
        UserInfo userInfo = null;
        try {
            userInfo = queryRunner.query(connection,sql,new BeanHandler<>(UserInfo.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(userInfo);
        resp.getWriter().print(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
