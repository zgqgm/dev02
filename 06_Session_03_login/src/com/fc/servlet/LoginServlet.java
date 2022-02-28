package com.fc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //*********        验证码         *********
        String code = req.getParameter("code");
        HttpSession codeSession = req.getSession(false);
        String codeValue=(String)codeSession.getAttribute("code");
        if (username.equals("小明")&&password.equals("123")){
            //创建Session
            HttpSession session = req.getSession(true);
            session.setAttribute("username",username);
            //设置有效期(一个小时)
            session.setMaxInactiveInterval(60*60);
            //创建Cookie
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            //设置Cookie有效期（一个小时）
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.sendRedirect("index");
        }else if (code == null || code.equals("")){
            resp.getWriter().write("请输入验证码");
            return;
        }else if (code.equals(codeValue)){
            
            resp.getWriter().write("验证成功" +
                    "<h5><a href='login.html' style='color:green'>返回上一页面</a></h5>");
            //销毁Session键
            req.getSession().removeAttribute("code");
            return;
        }else {
            resp.sendRedirect("fail.html");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
/*           *******  老师验证码判断（自己写的验证码失效没写），尽力参照老师的  *********
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 获取前端的请求参数
        String code = req.getParameter("code");

        // 如果没有输入验证码，提示验证码为空禁止继续操作
        if (code == null || code.equals("")) {
            resp.getWriter().write("请输入验证码！");
            return;
        }

        // 获取所有的Cookie
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            // 如果传递了time对应的Cookie，说明验证码没到期
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")) {
                    HttpSession session = req.getSession(false);

                    String value = (String) session.getAttribute("code");

                    // 如果传递的验证码和session中存储的一样
                    if (code.equals(value)) {
                        // 说明验证
                        resp.getWriter().write("验证成功");

                        // 验证成功后必须销毁session中的数据和Cookie
                        session.removeAttribute("code");
                    } else {
                        // 不一样，说明验证码输入错误
                        resp.getWriter().write("验证码错误，请重新输入");
                    }

                    return;
                }
            }
        }

        // 如果没有接收到任何的Cookie，说明验证码已经失效了
        // session中的验证码也没用了
        req.getSession(false).removeAttribute("code");

        resp.getWriter().write("验证码已经失效，请重新获取");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }*/
