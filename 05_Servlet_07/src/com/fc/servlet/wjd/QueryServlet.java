package com.fc.servlet.wjd;

import com.fc.servlet.bean.Student;
import com.fc.servlet.druidUtil.DruidUtil;
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
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获取连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "select * from student";
        List<Student> list = null;
        try {
            // 查询，获取包含了所有学生对象的list集合
            list = queryRunner.query(connection, sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String html =
                "<table border='1px' width='800px' align='center'>" +
                "<caption><h1 style='color: chartreuse'>学生信息</h1></caption>" +
                "<tr>" +
                "<th>学号</th>" +
                "<th>姓名</th>" +
                "<th>年龄</th>" +
                "<th>性别</th>" +
                "<th>信息</th>" +
                "<th>操作</th>" +
                "</tr>";
        if (list != null && list.size() != 0){
            for (Student student : list) {
                html+=  "<tr><td align='center'>"+
                        student.getId()+
                        "</td>"+
                        "<td align='center'>" +
                        student.getName()+
                        "</td>"+
                        "<td align='center'>" +
                        student.getAge()+
                        "</td>"+
                        "<td align='center'>" +
                        student.getGender()+
                        "</td>"+
                        "<td align='center'>" +
                        student.getInfo()+
                        "</td>"+
                        "<td align='center'>" +
                        "<a href='select?id=" +
                        student.getId() +
                        "'>修改</a>&nbsp;&nbsp;&nbsp;" +
                        "<a style='color: black' id='"+student.getId()+
                        "' onmouseover='over("+student.getId()+
                        ")' onmouseout='out("+student.getId()+
                        ")' onclick='del(" +
                        student.getId() +
                        ");'>删除</a>" +
                        "</td>"+
                        "</tr>" ;
            }
        }
        html+= "<tr>" +
                "<td colspan='6' align='center'>" +
                "<a href='add.html'>添加学生</a>" +
                "</td>" +
                "</tr>" +
              "</table>";
        html += "<script>" +
                "function del(id) {" +
                "if (confirm('您是否确认删除？') === true) {" +
                "window.location.href = 'delete?id=' + id;" +
                "}" +
                "}" +
                "function over(id) {" +
                "var a=document.getElementById(id);" +
                "a.style.color='red';" +
                "a.style.cursor='hand'" +
                "}" +
                "function out(id) {" +
                "var a=document.getElementById(id);;" +
                "a.style.color='';" +
                "a.style.cursor='point'" +
                "}"+
                "</script>";
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
