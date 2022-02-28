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

@WebServlet("/SM")
public class SelectMenu extends HttpServlet {
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
        String sql = "select nmi.id,nm.name AS cut,nmi.name from nav_menu_re_item join nav_menu nm on nav_menu_re_item.menu_id = nm.id join nav_menu_item nmi on nav_menu_re_item.item_id = nmi.id "+
                "where nmi.id = ?";
        menuInfo que = null;
        try {
            que = queryRunner.query(connection,sql,new BeanHandler<>(menuInfo.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("que", que);

        req.getRequestDispatcher("upmenu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
