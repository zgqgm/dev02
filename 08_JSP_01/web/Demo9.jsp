<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试6个JSP动作</title>
</head>
<body>
<%--用来创建对象--%>
<jsp:useBean id="student" class="com.fc.bean.Student">
    <%--用于给对象的属性进行赋值操作--%>
    <jsp:setProperty name="student" property="id" value="1"/>
    <jsp:setProperty name="student" property="name" value="易烊千玺"/>
    <jsp:setProperty name="student" property="age" value="22"/>
    <jsp:setProperty name="student" property="gender" value="男"/>
    <jsp:setProperty name="student" property="info" value="四字弟弟"/>

    <%--获取指定对应的属性值--%>
    <jsp:getProperty name="student" property="id"/>
    <jsp:getProperty name="student" property="name"/>
    <jsp:getProperty name="student" property="age"/>
    <jsp:getProperty name="student" property="gender"/>
    <jsp:getProperty name="student" property="info"/>
</jsp:useBean>
</body>
</html>
