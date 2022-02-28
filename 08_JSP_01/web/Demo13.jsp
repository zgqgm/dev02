<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试pageContext获取其他的内置对象</title>
</head>
<body>
<%=pageContext.getRequest()%>
<%=pageContext.getResponse()%>
<%=pageContext.getServletContext()%>
<%=pageContext.getServletConfig()%>
<%=pageContext.getSession()%>
<%=pageContext.getPage()%>
<%=pageContext.getOut()%>
<%=pageContext.getException()%>
</body>
</html>
