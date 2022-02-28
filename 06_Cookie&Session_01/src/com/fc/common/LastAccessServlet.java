package com.fc.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

@WebServlet("/lastAccess")
public class LastAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        resp.setContentType("text/html; charset=UTF-8");
        // 获取Cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                // 如果传递过来了一个叫time的cookie说明不是第一次访问
                if (cookie.getName().equals("time")){
                    // 获取Cookie中的值
                    String value = cookie.getValue();
                    // URL解码
                    String decoder = URLDecoder.decode(value,"UTF-8");
                    resp.getWriter().write("上一次访问的时间为：" + decoder);
                    updateDateTime(resp,cookie);
                    return;
                }
            }
        }
        //创建Cookie
        Cookie cookies1 = new Cookie("time","");
        // 更新时间
        updateDateTime(resp, cookies1);
        resp.getWriter().write("欢迎第一次访问");
    }
    public void updateDateTime (HttpServletResponse resp,Cookie cookie) throws UnsupportedEncodingException {
        // 获取时间日期格式化器
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取时间戳
        String dateTime = format.format(System.currentTimeMillis());
        //URL编码
        String encode = URLEncoder.encode(dateTime,"UTF-8");
        // 更新Cookie的值
        cookie.setValue(encode);
        // 发送到浏览器
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
