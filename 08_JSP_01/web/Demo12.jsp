<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试域对象的属性方法</title>
</head>
<body>
<%
    pageContext.setAttribute("username","玛卡巴卡");
    request.setAttribute("username","唔西迪西");
    session.setAttribute("username","汤不理不");
    application.setAttribute("username","依古比古");
%>
<%= pageContext.getAttribute("username")%>
<%= request.getAttribute("username")%>
<%= session.getAttribute("username")%>
<%= application.getAttribute("username")%>
</body>
</html>
