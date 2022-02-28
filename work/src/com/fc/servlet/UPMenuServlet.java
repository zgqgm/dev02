package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/UPS")
public class UPMenuServlet extends HttpServlet {
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
        String sql1 ="update nav_menu_item set name = ? where id = ?";
        String sql2 ="SELECT id from nav_menu where name = ?";
        String sql3 ="UPDATE nav_menu_re_item set menu_id = ? where item_id = ?";
        int affection = 0;
        menuInfo querys =null;
        try {
            affection = queryRunner.update(connection, sql1,menuInfos.getName(),menuInfos.getId());
            querys = queryRunner.query(connection, sql2, new BeanHandler<>(menuInfo.class), menuInfos.getCut());
            queryRunner.update(connection, sql3, querys.getId(), menuInfos.getId());

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
