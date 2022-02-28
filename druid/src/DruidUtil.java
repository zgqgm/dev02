import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;


public class DruidUtil {
    private static DataSource dataSource = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        //获取属性集对象
        Properties properties = new Properties();

        try {
            //反射
            properties.load(new FileReader(new File("./src/druid.properties")));

            // 加载数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        try {
            //获取数据库连接池的连接
            connection = dataSource.getConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return connection;
    }

    // 获取搬运工对象
    private static Statement getStatement() {
        // 非空操作
        if (connection == null) {
            connection = getConnection();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return statement;
    }

    // 增删改操作
    public static int update(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        int affectedRows = 0;//受影响的行数

        try {
            affectedRows = statement.executeUpdate(sql);//执行sql语句
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(statement, connection);
        }


        return affectedRows;
    }

    // 执行查询操作
    public static ResultSet query(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return resultSet;
    }

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
