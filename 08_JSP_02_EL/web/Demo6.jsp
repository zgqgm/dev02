<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试获取后端的参数</title>
</head>
<body>
<%
    request.setAttribute("username","易烊千玺");
    ArrayList<Student> list = new ArrayList<>();
    list.add(new Student(1, "Hello Kitty", 3, "女", "粉色的猫"));
    list.add(new Student(2, "虹猫", 5, "女", "黑小虎"));
    list.add(new Student(3, "加菲猫", 4, "男", "吃披萨"));
    list.add(new Student(4, "Tom", 5, "男", "Jerry"));
    list.add(new Student(5, "机器猫", 30, "男", "哆啦A梦"));
    request.setAttribute("list",list);
    request.getRequestDispatcher("to.jsp").forward(request, response);
%>
</body>
</html>
