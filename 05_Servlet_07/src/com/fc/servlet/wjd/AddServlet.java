package com.fc.servlet.wjd;

import com.fc.servlet.bean.Student;
import com.fc.servlet.druidUtil.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletContext;
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

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取前端请求参数
        Map<String,String[]> map = req.getParameterMap();
        // 准备一个空的学生对象
        Student student = new Student();
        try {
            // 将map中的内容填充到学生类对象中
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //创建查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获得连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "insert into student(name,age,gender,info) values(?,?,?,?)";
        int affection = 0;
        try {
            affection = queryRunner.update(connection, sql, student.getName(), student.getAge(), student.getGender(), student.getInfo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affection!=0){
            //添加成功
            req.getRequestDispatcher("/query").forward(req,resp);
        }else {
            //添加失败
            resp.getWriter().write("<script>" +
                    "alert('添加失败');" +
                    "</script>");
            //req.getRequestDispatcher("/add").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
