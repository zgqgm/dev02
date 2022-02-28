<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSTL中forEach的属性</title>
</head>
<body>
<table align="center" border="1">
    <tr>
        <th>下标</th>
        <th>内容</th>
        <th>幅度</th>
        <th>从哪开始</th>
        <th>到哪结束</th>
        <th>计数</th>
        <th>是否是第一个</th>
        <th>是否是最后一个</th>
    </tr>
    <c:forEach begin="1" end="10" step="1" var="temp" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${status.current}</td>
            <td>${status.step}</td>
            <td>${status.begin}</td>
            <td>${status.end}</td>
            <td>${status.count}</td>
            <td>${status.first}</td>
            <td>${status.last}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
