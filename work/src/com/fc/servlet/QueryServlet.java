package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.PageInfo;
import com.fc.bean.UserInfo;
import com.fc.druidUtil.DruidUtil;
import com.fc.service.StudentService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");

        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获取连接对象
        Connection connection = DruidUtil.getConnection();
        List<UserInfo> list = null;

            //sql语句
            String sql = "select * from userinfo";
            try {
                // 查询，获取包含了所有学生对象的list集合
                list = queryRunner.query(connection, sql,new BeanListHandler<>(UserInfo.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().print(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
