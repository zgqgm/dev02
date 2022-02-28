package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.UserInfo;
import com.fc.bean.menuInfo;
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

@WebServlet("/addme")
public class AddMen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();
        // 准备一个用户对象
        menuInfo menuInfos = objectMapper.readValue(parameter, menuInfo.class);
        //创建查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "insert into nav_menu_item(name) values(?)";
        String sql1 ="SELECT id from nav_menu_item where name = ?";
        String sql2 ="SELECT id from nav_menu where name = ?";
        String sql3 ="insert into nav_menu_re_item(menu_id, item_id) VALUES (?,?)";
        int affection = 0;
        menuInfo query =null;
        menuInfo querys =null;
        try {
            affection = queryRunner.update(connection, sql, menuInfos.getName());
            query = queryRunner.query(connection, sql1, new BeanHandler<>(menuInfo.class), menuInfos.getName());
            querys = queryRunner.query(connection, sql2, new BeanHandler<>(menuInfo.class), menuInfos.getCut());
            queryRunner.update(connection, sql3, querys.getId(), query.getId());

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
