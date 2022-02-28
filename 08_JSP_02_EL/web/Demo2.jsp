<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试通过EL表达式来获取对象中的数据</title>
</head>
<body>
<%
    Student student = new Student(1,"玛卡巴卡",18,"男","四个字");
    pageContext.setAttribute("student",student);
%>
<table border="1" align="center">
    <caption>表格展示</caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.gender}</td>
        <td>${student.info}</td>
    </tr>
</table>
</body>
</html>
