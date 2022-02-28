<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp中使用循环：表格</title>
</head>
<body>
<%
    ArrayList<Student> students = new ArrayList<>();
    students.add(new Student(1,"易烊千玺",22,"男","四字弟弟"));
    students.add(new Student(2,"王俊凯",23,"男","三字弟弟"));
    students.add(new Student(3,"王源",21,"男","二字弟弟"));
%>
<table border="1" align="center">
    <caption>
        for-表格
    </caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>昵称</th>
    </tr>
    <%
        for (Student student : students) {
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
