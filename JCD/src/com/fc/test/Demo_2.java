package com.fc.test;

import database.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import studentPC.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo_2 {
    @Test//添加
    public void add(){
        //获取链接
        Connection connection = JDBCUtil.getConnection();
        //提取资源
        PreparedStatement preparedStatement = null;
        //sql语句
        String sql = "insert into student(id,name,age,score) values(?,?,?,?)";
        try {
            //获取预处理的搬运工对象
            preparedStatement = connection.prepareStatement(sql);
            //设置预处理的值
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"测试");
            preparedStatement.setInt(3,16);
            preparedStatement.setInt(4,99);
            //执行sql语句
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数："+affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }

    @Test//删除
    public void testDelete() {
        //获取链接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "delete from student where id = ?";
        //获取资源
        PreparedStatement preparedStatement = null;
        try {
            //获取预处理的搬运工对象
            preparedStatement = connection.prepareStatement(sql);
            //设置预处理的值
            preparedStatement.setInt(1,5);
            //执行sql语句
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
    @Test//替换
    public void testUpdate(){
       //获取链接
       Connection connection = JDBCUtil.getConnection();
       //sql语句
        String sql = "update student set name = ? where id = ?";
        //获取资源
        PreparedStatement preparedStatement = null;
        try {
            //获取预处理的搬运工对象
            preparedStatement = connection.prepareStatement(sql);
            //设置预处理的值
            preparedStatement.setString(1,"测试");
            preparedStatement.setInt(2,6);
            //执行sql语句
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
}
