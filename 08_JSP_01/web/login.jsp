<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.fc.uitl.DruidUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanHandler" %>
<%@ page import="com.fc.bean.Student" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录业务逻辑</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    System.out.println(username + password);

    QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();

    String sql = "select * from user where username = ? and password = ?";

    Student student = null;

    try {
        student = queryRunner.query(connection, sql, new BeanHandler<>(Student.class), username, password);
    } catch (SQLException throwable) {
        throwable.printStackTrace();
    }

    if (student == null) {
        // 登录失败
%>
<%="登录失败"%>
<%
} else {
%>
<%="登录成功"%>
<%
    }
%>
</body>
</html>
