<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2022/1/13
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传成功页</title>
</head>
<body>
<c:if test="${not empty list}">
    <c:forEach var="img" items="${list}">
        <img src="http://localhost:8081/upload/${img}">
        <form action="download?filename=${img}" method="post">
            <input type="submit" value="下载">
        </form>
    </c:forEach>
</c:if>
</body>
</html>
