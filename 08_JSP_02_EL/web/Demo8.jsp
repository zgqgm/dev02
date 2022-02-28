<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试jstl中的if标签</title>
</head>
<body>
<c:if test="true">
    真香
</c:if>
<c:if test="flase">
    有啥吃啥
</c:if>
<c:if test="${empty list}">
    集合是空的
</c:if>
<c:if test="${10>1}">
    10>1
</c:if>
</body>
</html>
