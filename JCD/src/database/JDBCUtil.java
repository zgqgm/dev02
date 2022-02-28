package database;

import org.junit.Test;
import studentPC.Student;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//JDBC工具类
public class JDBCUtil {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        //获取属性集对象
        Properties properties = new Properties();
        try{
            //反射
            properties.load(new FileReader(new File("./src/jdbc.properties")));

            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            //获取链接
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement(){
        if (connection == null){
            statement = getStatement();
        }
        try {
            //获取搬运工
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static int update(String sql) {
        if (statement == null){
            statement = getStatement();
        }
        int affectedRows = 0;
        try {
            //执行SQL语句
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return affectedRows;
    }

    public static ResultSet query(String sql){
        if (statement == null){
            statement = getStatement();
        }
        try {//获取结果并对其设置
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return resultSet;
    }

    //闭流
    private static void close(Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet) {
        close(resultSet, statement, connection);
    }

    public static void close(Statement statement, Connection connection) {
        close(resultSet, statement, connection);
    }

    private static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
