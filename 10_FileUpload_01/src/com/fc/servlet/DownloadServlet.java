package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求参数获取文件名
        String filename = req.getParameter("filename");
        //声明下载路径
        String path = "C:/worker/apache-tomcat-8.5.37-windows-x64/server/apache-tomcat-8.5.37/webapps/upload";
        //创建File对象
        File file = new File(path,filename);
        //固定格式，设置响应头告知浏览器以文件下载的方式来打开
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //声明输入输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        //准备一个缓冲
        byte[] buffer = new byte[1024*8];
        //读操作
        while (inputStream.read(buffer) != -1){
            //写操作
            outputStream.write(buffer);
            //刷新页面
            outputStream.flush();
        }
        // 关闭资源
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
