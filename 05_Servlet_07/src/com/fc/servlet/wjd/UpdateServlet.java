package com.fc.servlet.wjd;

import com.fc.servlet.bean.Student;
import com.fc.servlet.druidUtil.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("UTf-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取参数
        Map<String,String[]> map = req.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "update student set name = ?, age = ?, gender = ?, info = ? where id = ?";
        int affectedRows = 0;

        try {
            affectedRows = queryRunner.update(connection, sql, student.getName(), student.getAge(), student.getGender(), student.getInfo(), student.getId());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        String html = "<script>";

        if (affectedRows != 0) {
            // 修改成功
            html += "   alert('修改成功');";

        } else {
            // 修改失败
            html += "   alert('修改失败');";
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
