package com.fc.servlet;

import com.fc.bean.PUserInfo;
import com.fc.bean.User;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

@WebServlet("/person")
public class PersonInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("name");
       //查询运行器
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        String sql1="select id from user where username = ?";
        User query1 = null;
        try {
           query1= queryRunner.query(connection, sql1, new BeanHandler<>(User.class), parameter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //sql语句
        String sql = "select * from user_re_user_info s left join user_info ui on ui.id = s.user_info_id where s.user_id = ?";
        List<PUserInfo> query = null;
        try {
            assert query1 != null;
            query = queryRunner.query(connection, sql, new BeanListHandler<>(PUserInfo.class),query1.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("PUserInfo",query);
        req.getRequestDispatcher("userInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
