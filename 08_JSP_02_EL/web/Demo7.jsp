<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试JSTL</title>
</head>
<body>
<%--设置属性键值对--%>
<c:set var="username" value="易烊千玺" scope="session"/>
<%--用来输出内容到页面--%>
<c:out value="${username}"/>
<c:out value="真香"/>
<%--    移除指定域中的属性键值对--%>
<c:remove var="username" scope="session"/>
${username}
</body>
</html>
