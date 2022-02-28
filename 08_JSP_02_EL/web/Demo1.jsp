<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试EL表达式</title>
</head>
<body>
<%
    //pageContext.setAttribute("username", "金毛狮王");
    //request.setAttribute("username", "白眉鹰王");
    session.setAttribute("username", "青翼蝠王");
    application.setAttribute("username", "紫衫龙王");
%>
${username}<%--相当于jsp中的findAttribute--%>
</body>
</html>
