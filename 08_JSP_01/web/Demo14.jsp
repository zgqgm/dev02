<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试通过pageContext操作其他的域对象</title>
</head>
<body>
<%
    pageContext.setAttribute("username","玛卡巴卡");
    request.setAttribute("username", "唔西迪西");
    session.setAttribute("username", "汤不里不");
    application.setAttribute("username", "依古比古");
%>
<%--  通过pageContext操作其他的域对象  --%>
<%
    pageContext.setAttribute("username","易烊千玺",pageContext.SESSION_SCOPE);
%>
<%=pageContext.getAttribute("username")%>
<%=request.getAttribute("username")%>
<%=session.getAttribute("username")%>
<%=application.getAttribute("username")%>
<%=pageContext.getAttribute("username",PageContext.PAGE_SCOPE)%>
</body>
</html>
