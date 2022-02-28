package com.fc.servlet.wjd;

import com.fc.servlet.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取参数
        String parameter = req.getParameter("id");
        //转为Integer类型
        int id = Integer.parseInt(parameter);
        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获取连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "delete from student where id = ?";
        int affectedRows = 0;
        try {
            affectedRows = queryRunner.update(connection,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String html = "<script>";
        if (affectedRows != 0) {
            // 删除成功
            html += "   alert('删除成功');";

        } else {
            // 删除失败
            html += "   alert('删除失败');";
        }

        html += "   window.location.href = 'query'" +
                "</script>";

        resp.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
