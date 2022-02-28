<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试动态包含</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="username" value="易烊千玺"/>
</jsp:include>
动态页面
<jsp:include page="footer.jsp"/>


</body>
</html>
