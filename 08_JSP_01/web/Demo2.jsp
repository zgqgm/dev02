<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="error.jsp" buffer="none" session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试page指令</title>
</head>
<body>
<%
    int num = 1/0;
    response.getWriter().write("error");
%>
<%=1%>
<%
    response.getWriter().write("error2");
%>
<%=2%>
</body>
</html>
