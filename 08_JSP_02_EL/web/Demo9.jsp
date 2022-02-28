<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSTL中choose</title>
</head>
<body>
<c:set var="score" value="109"/>

<c:choose>
    <c:when test="${score >= 90}">
        优秀
    </c:when>
    <c:when test="${score >= 80}">
        良好
    </c:when>
    <c:when test="${score >= 70}">
        不错
    </c:when>
    <c:when test="${score >= 60}">
        还行
    </c:when>
    <c:otherwise>
        垃圾
    </c:otherwise>
</c:choose>
</body>
</html>
