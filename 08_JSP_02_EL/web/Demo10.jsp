<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.fc.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSTL中的forEach标签</title>
</head>
<body>
<%
    List<Student> list = new ArrayList<>();

    list.add(new Student(1, "Hello Kitty", 3, "女", "粉色的猫"));
    list.add(new Student(2, "虹猫", 5, "女", "黑小虎"));
    list.add(new Student(3, "加菲猫", 4, "男", "吃披萨"));
    list.add(new Student(4, "Tom", 5, "男", "Jerry"));
    list.add(new Student(5, "机器猫", 30, "男", "哆啦A梦"));

    pageContext.setAttribute("list", list);
%>
<table border="1" align="center">
    <caption>jstl</caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
    </tr>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
            <td>${student.info}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
