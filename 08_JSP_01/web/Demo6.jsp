<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP测试：登录</title>
</head>
<body>
<form action="login.jsp" method="post">
    <table align="center">
        <caption>登录</caption>
        <tr>
            <td>账号</td>
            <td><input type="text" value="" name="username" autofocus></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" value="" name="password"></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
