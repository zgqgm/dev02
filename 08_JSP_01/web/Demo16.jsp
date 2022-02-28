<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试通过pageContext进行包含和转发操作</title>
</head>
<body>
<%
    request.setAttribute("username","易烊千玺");
%>
<%
    //pageContext.include("footer.jsp");
%>
<%
    pageContext.forward("footer.jsp");
%>
</body>
</html>
