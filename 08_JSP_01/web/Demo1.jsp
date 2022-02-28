<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/17
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试第一个JSP，脚本</title>
</head>
<body>
<%
    //没有 ！ 就是定义在方法中等（局部变量）
    int a = 5;
    int sum = sum(a,b);
    System.out.println("求和结果：" +sum);
    ArrayList<String> strings = new ArrayList<>();
    strings.add("烤羊排");
    strings.add("烤韭菜");
    strings.add("烤地瓜");
    strings.add("烤土豆");
    strings.add("烤乳猪");
    for (String string : strings) {
        %>
<span style="color: chartreuse">看结果</span>
<%=string%>
<%
    }
%>
<%!
    //有 ！ 就是定义在类中（成员变量）
    // 类中能写的代码，这些都能写
    // 注释也能写
    int b = 8;
%>
<!-- HTML中的注释 -->
<%-- jsp中的注释 --%>
<%-- 参数能写的这里都能写 --%>
<%=b%>
<%--<%=student%>--%>
<%!
    public int sum(int num1,int num2){
        return num1+num2;
    }
%>
<%!
    Student student = new Student(1,"易烊千玺",22,"男","四字弟弟");
%>
<%=student%>
</body>
</html>
