<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP中的转发</title>
</head>
<body>
<jsp:forward page="header.jsp">
    <jsp:param name="username" value="我是转发"/>
</jsp:forward>
</body>
</html>
