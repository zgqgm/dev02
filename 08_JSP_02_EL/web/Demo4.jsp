<%@ page import="java.util.Map" %>
<%@ page import="com.fc.bean.Student" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/19
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试通过EL表达式来获取对象中的数据</title>
</head>
<body>
<%
    Map<String, Student> map = new HashMap<>();
    map.put("student1",new Student(1, "Hello Kitty", 3, "女", "粉色的猫"));
    map.put("student2",new Student(2, "虹猫", 5, "女", "黑小虎"));
    map.put("student3",new Student(3, "加菲猫", 4, "男", "吃披萨"));
    map.put("student4",new Student(4, "Tom", 5, "男", "Jerry"));
    map.put("student5",new Student(5, "机器猫", 30, "男", "哆啦A梦"));
    pageContext.setAttribute("map",map);
%>
<table border="2" align="center">
    <caption>map</caption>
    <tr>
        <th>
            编号
        </th>
        <th>
            姓名
        </th>
        <th>
            年龄
        </th>
        <th>
            性别
        </th>
        <th>
            信息
        </th>
    </tr>
    <tr>
        <td>${map.student1.id}</td>
        <td>${map.student1.name}</td>
        <td>${map.student1.age}</td>
        <td>${map.student1.gender}</td>
        <td>${map.student1.info}</td>
    </tr>
    <tr>
        <td>${map["student2"].id}</td>
        <td>${map["student2"].name}</td>
        <td>${map["student2"].age}</td>
        <td>${map["student2"].gender}</td>
        <td>${map["student2"].info}</td>
    </tr>
    <tr>
        <td>${map.student3.id}</td>
        <td>${map.student3.name}</td>
        <td>${map.student3.age}</td>
        <td>${map.student3.gender}</td>
        <td>${map.student3.info}</td>
    </tr>
    <tr>
        <td>${map["student4"].id}</td>
        <td>${map["student4"].name}</td>
        <td>${map["student4"].age}</td>
        <td>${map["student4"].gender}</td>
        <td>${map["student4"].info}</td>
    </tr>
</table>
</body>
</html>
