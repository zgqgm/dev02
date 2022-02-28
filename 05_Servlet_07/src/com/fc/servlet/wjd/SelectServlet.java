package com.fc.servlet.wjd;

import com.fc.servlet.bean.Student;
import com.fc.servlet.druidUtil.DruidUtil;
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
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取参数
        String param = req.getParameter("id");
        int id = Integer.parseInt(param);
        //获得查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        //sql
        String sql = "select * from student where id = ?";
        Student student = null;
        try {
            student = queryRunner.query(connection,sql,new BeanHandler<>(Student.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String html = "";

        if (student == null) {
            html += "<script>" +
                    "alert('查无此人！！');" +
                    "window.location.href = 'query'" +
                    "</script>";
        } else {
            html += "<form action='update' method='post'>" +
                    "<table align='center'>" +
                    "<caption><h1 style='color: pink'>修改学生</h1></caption>" +
                    "<tr>" +
                    "<td>学号</td>" +
                    "<td><input readonly type='text' name='id' value='" + student.getId() + "'></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>姓名</td>" +
                    "<td><input type='text' name='name' value='" + student.getName() + "'></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>年龄</td>" +
                    "<td><input type='text' name='age' value='" + student.getAge() + "'></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>性别</td>" +
                    "<td>";
            if (student.getGender().equals("男")) {
                html += "<input type='radio' name='gender' value='男' checked>男" +
                        "<input type='radio' name='gender' value='女'>女";
            } else {
                html += "<input type='radio' name='gender' value='男'>男" +
                        "<input type='radio' name='gender' value='女' checked>女";
            }

            html += "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>信息</td>" +
                    "<td><input type='text' name='info' value='" + student.getInfo() + "'></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td colspan='2' align='center'>" +
                    "<input type='submit' value='修改'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<input type='reset' value='重置'>" +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "</form>";
        }

        resp.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
