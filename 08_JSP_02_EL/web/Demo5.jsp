<%@ page import="com.fc.bean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试EL中的empty</title>
</head>
<body>
<%
    String st1 = null;
    String st2 = "";
    String st3 = new String();

    Student student = null;

    ArrayList<String> list = new ArrayList<>();
    pageContext.setAttribute("str1", st1);
    pageContext.setAttribute("str2", st2);
    pageContext.setAttribute("str3", st3);
    pageContext.setAttribute("student", student);
    pageContext.setAttribute("list", list);
%>
${empty str1}
${empty str2}
${empty str3}
${empty student}
${empty list}
</body>
</html>
