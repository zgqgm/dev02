package com.fc.servlet;

import com.fc.bean.User;
import com.fc.bean.UserInfo;
import com.fc.druidUtil.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Upload")
public class UploadImg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Session
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        if (user.getUsername() != null){
            //创建一个工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置单个文件大小
            upload.setFileSizeMax(1024*1024*10);
            //设置总文件大小
            upload.setSizeMax(1024*1024*50);
            //创建一个可变数组用来存储文件名
            ArrayList<String> listName = new ArrayList<>();
            //解析请求对象中包含的所有文件
            try {
                List<FileItem> fileItems = upload.parseRequest(req);
                //分别获取文件
                for (FileItem fileItem : fileItems) {
                    //将文件写入到指定路径
                    fileItem.write(new File("C:/worker/apache-tomcat-8.5.37-windows-x64/server/apache-tomcat-8.5.37/webapps/upload",fileItem.getName()));
                    //记录文件名
                    listName.add(fileItem.getName()); System.out.println(fileItem);
                    //创建查询运行对象
                    QueryRunner queryRunner = new QueryRunner();
                    //获得连接对象
                    Connection connection = DruidUtil.getConnection();
                    //sql语句
                    String sql1 = "update user_info set face = ?  where id = ?";
                    String imgName = "http://localhost:8081/upload/"+fileItem.getName();
                    int affection = 0;
                    try {
                        affection = queryRunner.update(connection, sql1,imgName,user.getId());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    HttpSession session1 = req.getSession();
                    session1.setAttribute("face",imgName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 将所有的名字进行传递
            req.setAttribute("list", listName);
            req.getRequestDispatcher("person?name="+user.getUsername()).forward(req, resp);
        }

        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
