<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用jsp测试基础代码：表格</title>
</head>
<body>
<%
    Student yyqx = new Student(1,"易烊千玺",22,"男","四字弟弟");
    Student wjk = new Student(2,"王俊凯",23,"男","三字弟弟");
    Student  wy= new Student(3,"王源",21,"男","二字弟弟");
%>
<table align="center" border="1">
    <caption>表格展示</caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>昵称</th>
    </tr>
    <tr>
        <td><%=yyqx.getId()%></td>
        <td><%=yyqx.getName()%></td>
        <td><%=yyqx.getAge()%></td>
        <td><%=yyqx.getGender()%></td>
        <td><%=yyqx.getInfo()%></td>
    </tr>
    <tr>
        <td><%=wjk.getId()%></td>
        <td><%=wjk.getName()%></td>
        <td><%=wjk.getAge()%></td>
        <td><%=wjk.getGender()%></td>
        <td><%=wjk.getInfo()%></td>
    </tr>
    <tr>
        <td><%=wy.getId()%></td>
        <td><%=wy.getName()%></td>
        <td><%=wy.getAge()%></td>
        <td><%=wy.getGender()%></td>
        <td><%=wy.getInfo()%></td>
    </tr>
</table>
</body>
</html>
