package com.fc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.bean.PageInfo;
import com.fc.bean.UserInfo;
import com.fc.bean.menuInfo;
import com.fc.druidUtil.DruidUtil;
import com.fc.service.MenuService;
import com.fc.service.StudentService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/showMenu")
public class ShowMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("pageNo");
        String cut= req.getParameter("cut");
        String tiaojian = req.getParameter("tiaojian");
        int pageNo = 1;

        if (parameter != null) {
            pageNo = Integer.parseInt(parameter);
        }
        if (cut == null||cut.equals("undefined")){
            cut = "";
        }
        if (tiaojian == null){
            tiaojian = "";
        }
        int pageSize = 5;
        PageInfo<menuInfo> pageInfo = new MenuService().getPageInfo(pageNo, pageSize,tiaojian,cut);

        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("menu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
