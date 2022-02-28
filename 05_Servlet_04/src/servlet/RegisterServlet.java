package servlet;

import com.fc.servlet.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //获取查询对象
        QueryRunner runner = new QueryRunner();
        //获取连接对象
        Connection connection = DruidUtil.getConnection();
        String sql = "insert into user(username,password) values(?,?)";
        int affectedRows = 0;
        try {
            affectedRows = runner.update(connection,sql,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRows>0){
            resp.getWriter().append("<h1 align='center' style='color : green'>注册成功</h1>");
        } else {
            resp.getWriter().append("<h1 align='center' style='color : red'>注册失败</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
