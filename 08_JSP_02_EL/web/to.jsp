<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试使用EL获取转发的请求对象中的属性值</title>
</head>
<body>
${username}
<table align="center" border="1px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
    </tr>

    <tr>
        <td>${list[0].id}</td>
        <td>${list[0].name}</td>
        <td>${list[0].age}</td>
        <td>${list[0].gender}</td>
        <td>${list[0].info}</td>
    </tr>
    <tr>
        <td>${list[1].id}</td>
        <td>${list[1].name}</td>
        <td>${list[1].age}</td>
        <td>${list[1].gender}</td>
        <td>${list[1].info}</td>
    </tr>
    <tr>
        <td>${list[2].id}</td>
        <td>${list[2].name}</td>
        <td>${list[2].age}</td>
        <td>${list[2].gender}</td>
        <td>${list[2].info}</td>
    </tr>
    <tr>
        <td>${list[3].id}</td>
        <td>${list[3].name}</td>
        <td>${list[3].age}</td>
        <td>${list[3].gender}</td>
        <td>${list[3].info}</td>
    </tr>
    <tr>
        <td>${list[4].id}</td>
        <td>${list[4].name}</td>
        <td>${list[4].age}</td>
        <td>${list[4].gender}</td>
        <td>${list[4].info}</td>
    </tr>
</table>
</body>
</html>
