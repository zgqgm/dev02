<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/23
  Time: 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <style>
        /* 清除默认样式 */
        *{margin:0;padding:0}
        li{list-style:none}
        img{vertical-align:top;border:none}
        #nav{
            height: 48px;
            width: 100%;
            margin-top: 0px;
            margin-left: 0px;
            float: left;

        }
        .after_nav{
            height: 50px;
            width: 150px;
            position: absolute;
            margin-left: 1102px;
            line-height: 50px;
        }
        .click_input,.click_input_1{
            width: 5rem;
            height: 3rem;
            position: relative;
            display: inline-block;
            float: right;
            margin-top:0px;
            margin-right: 68px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            word-break: break-all;
            background-color: darkgray;
            text-align: center;
        }
        .click_input{
            line-height: 77px;
        }
        .nav_sum:hover .click_input{
            color: red;
            cursor: pointer;
        }
        .list_ul{
            background-color: #fff;
            position: absolute;
            margin: 58px 0px 0px 0;
            width: 150px;
            display: none;
            z-index: 5;
        }
        .logout_div,.list_ul>li,.list_li_onCil{
            height: 37px;
            line-height: 37px;
        }
        .logout_div{
            border-top: 1px solid;
        }
        .list_li_onCil{
            background-color: lightgray;
            cursor: pointer;
        }
        form{
            position: absolute;
            margin-top: 79px;
            margin-left: 634px;
        }
        .list_li div{
            text-align: center;
        }
        #headimg{
            width: 25px;
            height: 25px;
            position: absolute;
            z-index: 1;
            border-radius: 50%;
            top: 2px;
            left: 30px;
        }
        <%--   *********************************  导航菜单start   ************************************************   --%>
        .before_nav{
            position: absolute;
            color: darkgray;
            height: 48px;
            line-height: 48px;
            font-size: 18px;
        }
        .before_list>li{
            display: inline-block;
            text-align: center;
            width: 126px;
            cursor: pointer;
        }
        .list_ul_l{
            float: left;
            background-color: white;
            color: black;
            width: 138px;
            display: none;
        }
        .list_lis_onCil{
            background-color: #a8a5a5;
            color: white;
        }
        .list_lis_L_onCil{
            background-color: #ababab;
            color: red;
        }
        <%--   *********************************  导航菜单end     ************************************************   --%>
    </style>
</head>
<body style="background-color: aqua">
<div id="nav" style="background-color: black">
    <div class="after_nav">
        <div class="nav_sum" onmouseleave="nav_sum_out()" onmouseenter="nav_sum_over()">
            <c:if test="${sessionScope.face != undfind}">
                <img src="${sessionScope.face}" id="headimg">
            </c:if>
            <span <c:if test="${sessionScope.face != undfind}">class="click_input"</c:if> <c:if test="${sessionScope.face == undfind}">class="click_input_1"</c:if>  onclick="login_register_fun()">登录/注册</span>
            <ul class="list_ul">
                <li class="list_li">
                    <div  onclick="personfun()">个人中心</div>
                </li>
                <li class="list_li">
                    <div>订单管理</div>
                </li>
                <li class="list_li">
                    <div>我的收藏</div>
                </li>
                <li class="list_li">
                    <div class="logout_div" onclick="logout_click()">退出</div>
                </li>
            </ul>
        </div>
    </div>
    <%--   *********************************  导航菜单start   ************************************************   --%>
    <div class="before_nav">
        <ul class="before_list">
            <li style="width: 200px;"  onclick="window.location.href='index.jsp'">校园外卖后台管理系统</li>
            <li class="list_lis" >
                <label onclick="window.location.href='showMenu'">导航分类管理</label>
                <ul class="list_ul_l">
                    <li class="list_lis_l_all" onclick="window.location.href='showMenu'">全部</li>
                    <li class="list_lis_l">美食</li>
                    <li class="list_lis_l">甜点饮品</li>
                    <li class="list_lis_l">超市便利</li>
                    <li class="list_lis_l">蔬菜水果</li>
                    <li class="list_lis_l">急救买药</li>
                </ul>
            </li>
            <li class="list_lis">外卖商家管理</li>
            <li class="list_lis">外卖菜品管理</li>
            <li class="list_lis">外卖订单管理</li>
            <li class="list_lis" onclick="window.location.href='PPage'">学生用户管理</li>
            <li></li>
        </ul>
    </div>
    <%--   *********************************  导航菜单end     ************************************************   --%>
</div>
<form >
    <table align="center">
        <caption><h1 align="center" style="color: chartreuse">修改用户信息</h1></caption>
        <tr>
            <td>编号</td>
            <td><div id="id"></div></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input id="name" type="text" name="name" value=""></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input id="age" type="text" name="age" value=""></td>
        </tr>
        <tr>
            <td>性别</td>
            <td align="center">
                <input id="male" type="radio" name="gender" value="男">男
                <input id="female" type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>信息</td>
            <td><input id="info" type="text" name="info" value=""></td>
        </tr>
        <tr >
            <td colspan="2" align="center">
                <input type="button" name="submit" onclick="button_up()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" name="reset" value="重置">
            </td>
        </tr>
    </table>
    </form>
</body>
<script>
    var emLi = document.getElementsByClassName("list_li");
    for (let j = 0; j < emLi.length; j++) {
        emLi[j].onmousemove=function(){
            this.setAttribute("class","list_li list_li_onCil");

        }
        emLi[j].onmouseout=function(){
            this.setAttribute("class","list_li");

        }
    }
    var nameID = "";
    var showName = "";
    var getId = document.cookie.split(";");
    let lens =getId.length;

    for (let da = 0;da<lens;da++){
        var arrName = getId[da].split("=");
        var nameArr = arrName[0].replace(/(^\s*)|(\s*$)/g,"");
        if (nameArr==="JSESSIONID"){
            nameID = arrName[1];
        }
        if(nameArr === "user"){
            showName = arrName[1];
        }
    }

    (function (){
        var users = $(".click_input");
        if (nameID !== ""){
            users.html(showName);
        }
    })();
    function personfun() {
        window.location.href="person?name="+showName;
    }
    //获取url
    let href = window.location.href;
    //查询url字符串中id的下标
    let b = href.lastIndexOf("id");
    //字符串截取，截取id=后的值
    let id = href.substring(b + 3);
    $.ajax({
        url:"select",
        type:"post",
        data:{"id":id},
        success:function (data) {
           var id = $("#id").append(data.id);
            var name =$("#name").val(data.name);
            var age = $("#age").val(data.age);
            var info = $("#info").val(data.info);
            if (data.gender === '男') {
                $("#male").attr('checked', "true");
            } else {
                $("#female").attr('checked', "true");
            }
        }
    })
    function button_up(){

        var name = $("#name").val();
        var age = $("#age").val();
        var gender = $("input:radio:checked").val();
        var info = $("#info").val();
        var data = {"id":id,"name": name, "age": age, "gender": gender, "info": info};

        // 将json对象转为json字符串
        var json = JSON.stringify(data);
        $.ajax({
            url: "upData",
            type: "post",
            data: {"data": json},
            success: function (data) {
                if (data === 0){
                    alert("修改失败。请稍后再试。");
                }else {
                    window.location.href="PPage";
                }
            }
        })
    }

    function nav_sum_over(){
        if (nameID !== ""){
            var tap = document.getElementsByClassName("list_ul")[0];
            tap.style.display='block';
            var strem = tap.style.marginTop;
            if ( strem !== "48px"){
                var num = 58;
                var time = setInterval(function(){
                    tap.style.marginTop=num+'px';
                    num-=1;

                    if(num>=48){}else{

                        clearInterval(time);
                    }
                },1)
            }
        }
    }
    function nav_sum_out() {
        var tap = document.getElementsByClassName("list_ul")[0];
        tap.style.display='';
        tap.style.marginTop='';
    }
    function logout_click() {
        var userShow = $(".click_input");
        $.ajax({
            url:"logout",
            type:"get",
            data:{},
            success:function (data){
                if (data === 'true'){
                    userShow.html("登录/注册");
                    window.location.href="index.jsp";
                }else {

                }
            }
        })
    }
    <%--   *********************************  导航菜单start   ************************************************   --%>
    let sumb = null;
    let emLis = document.getElementsByClassName("list_lis");
    let emLiss = document.getElementsByClassName("list_lis_l");
    let emLisu = document.getElementsByClassName("list_ul_l")[0];
    for (let j = 0; j < emLis.length; j++) {
        emLis[j].onmousemove=function(){
            this.setAttribute("class","list_lis list_lis_onCil");
            if (j === 0){
                emLisu.style.display="inline-block";
            }
            for (let i = 0; i < emLiss.length; i++) {
                emLiss[i].onmousemove=function(){
                    this.setAttribute("class","list_lis_l list_lis_L_onCil");
                    sumb = document.getElementsByClassName("list_lis_L_onCil")[0];
                    sumb.onclick=function () {
                        cutname = sumb.innerHTML;
                        window.location.href="showMenu?pageNo=${pageInfo.pageNo}&tiaojian=&cut="+cutname;
                    }
                }
                emLiss[i].onmouseout=function(){
                    this.setAttribute("class","list_lis_l");

                }
            }
        }
        emLis[j].onmouseout=function(){
            this.setAttribute("class","list_lis");
            if (j === 0) {
                emLisu.style.display = "none";
            }
        }
    }


    <%--   *********************************  导航菜单end     ************************************************   --%>
</script>
</html>
