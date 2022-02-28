<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<h1 align="center" style="color: red">操作过于频繁</h1>
<%
String message = exception.getMessage();
%>
<%=message%>
</body>
</html>
