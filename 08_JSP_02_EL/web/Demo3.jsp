<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fc.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/18
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试通过EL表达式来获取对象中的数据</title>
</head>
<body>
<%
    ArrayList<Student> students = new ArrayList<>();
    students.add(new Student(1, "Hello Kitty", 3, "女", "粉色的猫"));
    students.add(new Student(2, "虹猫", 5, "女", "黑小虎"));
    students.add(new Student(3, "加菲猫", 4, "男", "吃披萨"));
    students.add(new Student(4, "Tom", 5, "男", "Jerry"));
    students.add(new Student(5, "机器猫", 30, "男", "哆啦A梦"));
    pageContext.setAttribute("list",students);
%>
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
        <td>${list.get(1).id}</td>
        <td>${list.get(1).name}</td>
        <td>${list.get(1).age}</td>
        <td>${list.get(1).gender}</td>
        <td>${list.get(1).info}</td>
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
