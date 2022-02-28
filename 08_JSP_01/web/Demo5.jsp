<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.fc.uitl.DruidUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page import="com.fc.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP连接数据库</title>
</head>
<body>
<%
    //获得查询运行器
    QueryRunner queryRunner = new QueryRunner();
    //sql语句
    String sql = "select * from student";
    //获取链接
    Connection connection = DruidUtil.getConnection();
    List<Student> query = null;
    try {
        query = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<table align="center" border="2">
    <caption>数据库-表格</caption>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
    </tr>
    <%
        assert query != null;
        for (Student student : query) {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getGender()%></td>
        <td><%=student.getInfo()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
