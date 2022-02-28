package com.fc.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个工厂类对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置单个文件的大小
        upload.setFileSizeMax(1024*1024*10);
        //设置总大小
        upload.setSizeMax(1024*1024*50);
        //创建一个可变数组用来存储所有上传文件的文件名
        List<String> list = new ArrayList<>();
        //解析请求对象中包含的所有上传文件
         try {
            List<FileItem> fileItems = upload.parseRequest(req);
            //分别获取每一个上传的文件
            for (FileItem fileItem: fileItems){
                //将文件写入指定路径
                fileItem.write(new File("C:/worker/apache-tomcat-8.5.37-windows-x64/server/apache-tomcat-8.5.37/webapps/upload",fileItem.getName()));
                list.add(fileItem.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 将所有的名字进行传递
        req.setAttribute("list", list);
         req.getRequestDispatcher("success.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
