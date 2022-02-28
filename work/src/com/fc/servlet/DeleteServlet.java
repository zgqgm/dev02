package com.fc.servlet;

import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String parameter = req.getParameter("id");//拿到单个id对象
        String idList = req.getParameter("idList");//拿到id对象数组（字符串）
        //转为Integer类型
        int id = 0;
        if (parameter != null){//判断是否拿到的是单个id对象
            id = Integer.parseInt(parameter);//转为Integer对象
        }
        //获得查询运行对象
        QueryRunner queryRunner = new QueryRunner();
        //获取连接对象
        Connection connection = DruidUtil.getConnection();
        //sql语句
        String sql = "delete from userinfo where id = ?";
        int affectedRows = 0,i=0;
        if (idList != null){//判断是否拿到的是id数组对象
            String[] idArrays = idList.split(" ");//转存为String数组
            String[] count = new String[idArrays.length];//用来存储删除失败的id
            count[0] = "0";
            for (int idArray = 0;idArray<idArrays.length;idArray++) {
                int id1=Integer.parseInt(idArrays[idArray]);//依次转为Integer对象
                try {
                    affectedRows = queryRunner.update(connection,sql,id1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (affectedRows ==0){//判断是否删除
                    count[i]=idArrays[idArray];//没有删除则存起来
                    i++;
                }
            }
            String cstr= null;
            for (int c=0;c< count.length;c++){
                if (c != count.length-1 && count[c+1]!=null){//判断count数组是存有删除失败的id
                    cstr+=count[c]+",";//将id拼接到cstr中
                }else {
                    cstr+=count[c];
                    break;
                }
            }
            if (count[0].equals("0")){//全部删除返回0，否则返回cstr
                resp.getWriter().print(0);
            }else {
                resp.getWriter().print(cstr);
            }
        }else {//若拿到的是单个id
            try {
                affectedRows = queryRunner.update(connection,sql,id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.getWriter().print(affectedRows);//返回受影响的行
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
