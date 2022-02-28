package com.fc.servlet;
import org.apache.commons.beanutils.BeanUtils;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码集
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码集
        resp.setContentType("text/html; charset=UTF-8");

        // 获取根路径
        String contextPath = req.getContextPath();
        System.out.println("获取根路径：" + contextPath);

        // 获取协议
        String protocol = req.getProtocol();
        System.out.println("协议：" + protocol);

        // 获取请求方式
        String method = req.getMethod();
        System.out.println("请求方式：" + method);

        // 获取不带参数的URL
        StringBuffer url = req.getRequestURL();
        System.out.println("不带参数的URL:" + url);

        // 获取URL中的路径部分
        String uri = req.getRequestURI();
        System.out.println("URL中的路径：" + uri);

        // 获取get请求中的参数部分
        // post请求用不了
        String queryString = req.getQueryString();
        System.out.println("get请求的参数部分：" + queryString);

        // 获取请求的参数
        String name = req.getParameter("name");
        System.out.println("获取请求参数：" + name);

        // 获取请求参数的映射对象
        Map<String, String[]> map = req.getParameterMap();

        Set<Map.Entry<String, String[]>> entries = map.entrySet();

        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }

        Student student = new Student();

        try {
            // 将map中的内容填充到学生对象
            BeanUtils.populate(student, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(student);

        // 获取请求参数的所有参数名
        Enumeration<String> names = req.getParameterNames();

        while (names.hasMoreElements()) {
            String param = names.nextElement();

            System.out.println("参数名：" + param);

            // 根据参数名获取对应的参数值，是一个数组
            String[] values = req.getParameterValues(param);

            System.out.println("参数值：" + Arrays.toString(values));
        }

        String host = req.getRemoteHost();
        String user = req.getRemoteUser();
        String addr = req.getRemoteAddr();
        int port = req.getRemotePort();

        System.out.println(host);
        System.out.println(user);
        System.out.println(addr);
        System.out.println(port);

        // 获取请求头对应的值
        String origin = req.getHeader("Host");
        System.out.println("获取请求头的值：" + origin);

        // 设置响应状态码
        resp.setStatus(666);

        // 设置响应头
        resp.setHeader("name", "joker");

        resp.getWriter().write("<h1 align='center' style='color: pink'>刘同学的心</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
