<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP中的九个内置对象</title>
</head>
<body>
<%
    String uri = request.getRequestURI();
    System.out.println("路径"+uri);
    response.getWriter().write("响应对象没问题");
    String id = session.getId();
    System.out.println("session的id:"+id);
    //获取盘符的绝对路径
    String realPath = application.getRealPath("/");
%>
<%="获取盘符开始的绝对路径："+realPath%>
<%
ServletContext servletContext = config.getServletContext();
%>
<%=servletContext == application%>
<%
out.write("内置对象out和Response的getWriter（）方法差不多");
%>
<%= page == this%>
</body>
</html>
