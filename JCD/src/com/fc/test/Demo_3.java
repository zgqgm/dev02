package com.fc.test;

import database.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import studentPC.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Demo_3 {
    /*@Test//查询所有
    public void testQueryAll(){
        //获取查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建链接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "select * from student";
        //创建处理集合对象
        BeanListHandler<Student> handler = new BeanListHandler<>(Student.class);//学生类的字节码
        try {
            List<Student> list = queryRunner.query(connection,sql,handler);
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test//查询指定
    public void testQueryOne(){
        //获取查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql ="select * from student where id = ?";
        //创建处理对象
        BeanHandler<Student> handler = new BeanHandler<>(Student.class);
        try {
            Student student = queryRunner.query(connection,sql,handler,2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Test//接口(查询指定)----过于麻烦，不建议使用该方法写
    public void testInterface(){
        //创建查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "select * from student where id = ?";
        //获取结果处理设置
        ResultSetHandler<Student> resultSetHandler = new ResultSetHandler<Student>() {
            @Override
            public Student handle(ResultSet resultSet) throws SQLException {
                Student student = null;
                while (resultSet.next()){
                    int anInt = resultSet.getInt(1);
                    String string = resultSet.getString(2);
                    int anInt1 = resultSet.getInt(3);
                    int anInt2 = resultSet.getInt(4);

                    student = new Student(anInt,string,anInt1,anInt2);
                }
                return student;
            }
        };
        try {
            Student student = queryRunner.query(connection,sql,resultSetHandler,3);
            System.out.println(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//删除
    public void testDelete(){
        //创建查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "delete from student where id = ?";
        try {
            int affectedRows = queryRunner.update(connection,sql,5);
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test//替换
    public void testUpdate(){
        //创建查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "update student set name = ? where id = ?";
        try {
            int affectedRows = queryRunner.update(connection,sql,"替换",5);
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test//插入参数
    public void testParams(){
        //创建查询对象
        QueryRunner queryRunner = new QueryRunner();
        try {
            int affectedRows = queryRunner.update(JDBCUtil.getConnection(),"insert into student(id,name,age,score) value (?,?,?,?)",6,"插入",4,15);
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd(){
        //创建查询对象
        QueryRunner queryRunner = new QueryRunner();
        //创建连接对象
        Connection connection = JDBCUtil.getConnection();
        //sql语句
        String sql = "insert into student(id,name,age,score) value (?,?,?,?)";
        //插入参数赋值
        Object[] params={7,"插入",6,87};
        //受影响的行数
        int affectedRows = 0;
        try {
            affectedRows = queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("受影响的行数"+affectedRows);
    }
}
