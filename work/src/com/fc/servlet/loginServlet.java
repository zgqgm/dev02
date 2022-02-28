package com.fc.servlet;

import com.fc.bean.PUserInfo;
import com.fc.bean.User;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //获得查询运行器
        QueryRunner queryRunner = new QueryRunner();
        //创建连接
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user= queryRunner.query(connection, sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null){
            //创建Session
            HttpSession session = req.getSession(true);
            // 将登录信息存储到session中
            session.setAttribute("user", user);
            //创建Cookie
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            Cookie cookie1 = new Cookie("user",username);
            //设置有效期
            cookie.setMaxAge(60*30);
            cookie1.setMaxAge(60*30);
            //将cookie发送到浏览器
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            //sql语句
            String sql1 = "select * from user_re_user_info s left join user_info ui on ui.id = s.user_info_id where s.user_id = ?";
            PUserInfo query = null;
            try {
                query = queryRunner.query(connection, sql1, new BeanHandler<>(PUserInfo.class),user.getId());
                if(query != null){
                    HttpSession session1 = req.getSession();
                    session1.setAttribute("face",query.getFace());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //登录成功
            resp.getWriter().print("true");
        }else {
            //登录失败
            resp.getWriter().print("false");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
