import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Demo1 {
    @Test
    public void testQuery(){
        //获取查询对象
        QueryRunner queryRunner = new QueryRunner();
        //获取链接
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "select Sname,Ssex,Class from student";
        //创建处理集对象
        BeanListHandler<Student> beanListHandler = new BeanListHandler<>(Student.class);
        try {
            List<Student> list = queryRunner.query(connection,sql,beanListHandler);
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
