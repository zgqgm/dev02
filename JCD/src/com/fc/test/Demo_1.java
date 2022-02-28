package com.fc.test;

import studentPC.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo_1 {
    public static void main(String[] args) {
        //获取资源
        Connection connection=null;
        Statement statement=null;
        String sql=null;
        ResultSet resultSet = null;
        Student student=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //准备参数
            String url="jdbc:mysql://localhost:3306/study?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String username="root";
            String password="958824";
            //获取链接
            connection=DriverManager.getConnection(url,username,password);
            //获取搬运工
            statement=connection.createStatement();
            //准备sql语句
            //sql="Insert into student(id,name,age,score) VALUES (4,'小明',18,80)";/*插入添加*/
            //sql="delete from student where id = 1";/*条件删除*/
            //sql="update student set name = '流星' where id = 1";/*修改表中的数据*/
            sql="select * from student where id =1 ";
            //执行sql语句并获取受影响的行数
            //int line=statement.executeUpdate(sql);
            // 执行sql获取结果集对象
            resultSet= statement.executeQuery(sql);
            // 准备一个存放学生对象的容器
            List<Student> list = new ArrayList<>();
            // 如果还有下一行数据
            while (resultSet.next()){
                // 根据字段的下标获取对应的每一行的值
                /*int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                int anInt1 = resultSet.getInt(3);
                int anInt2 = resultSet.getInt(4);*/
                // 根据指定的列名获取对应的参数
                int anInt = resultSet.getInt("id");
                String string = resultSet.getString("name");
                int anInt1 = resultSet.getInt("age");
                int anInt2 = resultSet.getInt("score");
                student = new Student(anInt,string,anInt1,anInt2);
                // 将封装好的学生对象放到容器中
                list.add(student);
            }
            // 增强for遍历集合
            for (Student students : list) {
                System.out.println(students);
            }
            //System.out.println(line);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
                if (statement != null) {
                    statement.close();
                }
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
