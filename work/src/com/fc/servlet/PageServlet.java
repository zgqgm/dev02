package com.fc.servlet;

import com.fc.bean.PageInfo;
import com.fc.bean.UserInfo;
import com.fc.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/PPage")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("pageNo");
        String gender= req.getParameter("gender");
        String tiaojian = req.getParameter("tiaojian");
        int pageNo = 1;

        if (parameter != null) {
            pageNo = Integer.parseInt(parameter);
        }
        if (gender == null||gender.equals("undefined")){
            gender = "";
        }
        if (tiaojian == null){
            tiaojian = "";
        }
        int pageSize = 5;
        PageInfo<UserInfo> pageInfo = new StudentService().getPageInfo(pageNo, pageSize,tiaojian,gender);

        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
