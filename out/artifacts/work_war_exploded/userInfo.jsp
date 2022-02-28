<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2022/1/14
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <title>个人中心</title>
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
        .click_input{
            width: 5rem;
            height: 3rem;
            position: relative;
            display: inline-block;
            line-height: 77px;
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
        .list_li div{
            text-align: center;
        }
        /***************************************************************************/
        .header,.back,.img_back,.img,.text_back,.text_item,#sign,.sex_1,.sex_2,.la_1,.la_2,#sub_inp{
            position: relative;
        }
        .header{
            width: 100%;
            top: 48px;
            background-color: lightgray;
        }
        .hea_cen{
            height: 80px;
            width: 1050px;
            margin: 0 auto;
        }
        .hea_cen>h3{
            height: 80px;
            width: 120px;
            text-align: center;
            line-height: 0px;
            font-size: 26px;
            font-family: cursive;
        }
        .back{
            height: 646px;
            top: 48px;
        }
        .back_cen{
            margin: 0 auto;
            width: 1050px;
            background: aliceblue;
            height: 100%;
        }
        .img_back{
            margin: 0 auto;
            width: 150px;
            top: 20px;
        }
        .img_back_hov{
             position: absolute;
             width: 1536px;
             height: 726px;
             background-color: black;
             z-index: 1;
             left: -17px;
             top: -80px;
         }
        .img_show{
            width: 150px;
            height: 150px;
            border-radius: 50%;
            overflow: hidden;
            margin: 0 auto;cursor: pointer;
        }
        .img_show_hov{
            margin: 50px auto;
        }
        .img{

            top: -29px;
            left: -26px;
        }
        .text_back{
            top: 35px;
        }
        .text_back>ul{
            width: 500px;
            margin: 0 auto;
        }
        li{
            margin-bottom: 6px;
            height: 49.1px;
            line-height: 49.1px;
        }
        .text_item{
            font-size: 25px;
            font-family: cursive;
            width: 100px;
            display: inline-block;
            top: 4px;
        }
        li>input{
            height: 31px;
            font-size: 18px;
        }
        #pol{
            display: inline-block;
            color: darkgray;
        }
        #sign{
            top: -35px;
        }
        .sex_1{
            top: 10px;
            left: 26px;
        }
        .sex_2{
            top: 10px;
            left: 75px;
        }
        .la_1{
            left: 33px;
        }
        .la_2{
            left: 80px;
        }
        .overIn,.overIn_1{
            color: darkgray;
        }
        .overIn_1{
            display: inline-block;
        }
        #sub_inp{
            left: 210px;
            width: 80px;
            background-color: lightblue;
        }
        .back_up_hov{
            height: 36px;
            width: 63px;
            line-height: 36px;
            text-align: center;
            background-color: white;
            position: relative;
            top: -321px;
            left: -249px;
            cursor: pointer;
        }
        .new_up_hov{
            height: 36px;
            width: 67px;
            line-height: 36px;
            text-align: center;
            background-color: white;
            position: relative;
            top: -357px;
            left: 760px;
            overflow: hidden;
            cursor: pointer;
        }
        .up_hov{
            height: 36px;
            width: 67px;
            line-height: 36px;
            text-align: center;
            background-color: white;
            position: relative;
            top: -393px;
            left: 867px;
            overflow: hidden;
            cursor: pointer;
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
            top: -24px;
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
<body>
<div id="nav" style="background-color: black">
    <div class="after_nav">
        <div class="nav_sum" onmouseleave="nav_sum_out()" onmouseenter="nav_sum_over()">
            <img src="${PUserInfo[0].face}" id="headimg">
            <span class="click_input"  onclick="login_register_fun()">登录/注册</span>
            <ul class="list_ul">
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
<div class="header">
    <div class="hea_cen">
        <h3>个人中心</h3>
    </div>
</div>
<div class="back">
    <div class="back_cen">
        <div class="img_back">
            <form action="Upload" class="img_show" method="post" enctype="multipart/form-data">
                <c:if test="${empty listName}">
                    <img class="img" onclick="img_fun()" src="${PUserInfo[0].face}"  alt="头像">
                </c:if>
                <c:if test="${not empty listName}">
                    <img src="http://localhost:8081/upload/${img}" onclick="img_fun()" alt="头像">
                </c:if>
                <div id="back_up" onclick="clear_fun()"></div>
                <div id="new_up" onclick="file_sum.click()"></div>
                <div id="up" onclick="sum_in.click()"></div>
            </form>
        </div>
        <div class="text_back">
            <ul>
                <li>
                    <div class="text_item">昵称</div>
                    <input id="nickname" type="text" value="${PUserInfo[0].nickname}">
                    <div id="pol">注: 不能超过10个字</div>
                </li>
                <li>
                    <div class="text_item">用户名</div>
                    <input type="text" disabled id="username">
                </li>
                <li>
                    <div class="text_item" id="sign">个性签名</div>
                    <textarea id="text" cols="50" rows="4" maxlength="80" placeholder="不能超过80字">${PUserInfo[0].signature}</textarea>
                </li>
                <li>
                    <div class="text_item">性别</div>
                    <input type="radio" class="sex_1" name="sex" value="男" <c:if test="${PUserInfo[0].gender == '男'}"> checked </c:if> ><label class="la_1">男</label>
                    <input type="radio" class="sex_2" name="sex" value="女" <c:if test="${PUserInfo[0].gender == '女'}"> checked </c:if> ><label class="la_2">女</label>
                </li>
                <li>
                    <div class="text_item">出生日期</div>
                    <input type="date" id="date" value="${PUserInfo[0].birthday}">
                </li>
                <li>
                    <input type="file">
                </li>
                <li>
                    <div class="text_item overIn">其他信息</div>
                    <div class="overIn_1">*其他信息当前仅支持联系管理员进行修改</div>
                </li>
                <li>
                    <input id="sub_inp" type="submit" onclick="submitInfo()" value="保存">
                </li>
            </ul>
        </div>
    </div>
</div>
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
        let username=$("#username");
        if (nameID !== ""){
            users.html(showName);
            username.val(showName);
        }
    })();
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
    //****************************************************************
    let img_url = 'img/01.jpg?'+Date.parse(new Date());
    let imgs = new Image();
    imgs.src = img_url;
    let img_sty = document.getElementsByClassName("img")[0];
    let hh=0;
    let ww = 0;
    imgs.onload=function (){
        hh=imgs.height;
        ww=imgs.width;
        img_sty.style.height=hh/3+"px";
        img_sty.style.width=ww/3+"px";

    }


    function img_fun() {
        let back_sty = $(".img_back");
        let show_sty = $(".img_show");
        let imgs_sty = $(".img");
        back_sty.attr('class', "img_back_hov");
        show_sty.attr('class', 'img_show_hov');
        imgs_sty.attr('class', 'img_hov');
        img_sty.onclick = '';
        let show_hov_sty = document.getElementsByClassName("img_show_hov")[0];
        let img_hov_sty = document.getElementsByClassName("img_hov")[0];
        show_hov_sty.style.height = hh + "px";
        show_hov_sty.style.width = ww + "px";
        img_hov_sty.style.height = hh + "px";
        img_hov_sty.style.width = ww + "px";
        let back_up = $("#back_up");
        let new_up = $("#new_up");
        let up = $("#up");
        back_up.html("返回");
        back_up.attr('class','back_up back_up_hov');
        document.getElementById("new_up").innerHTML="选择头像<input id='file_sum' type ='file' name='file'>";
        new_up.attr("class",'new_up new_up_hov');
        document.getElementById("up").innerHTML="更换头像<input id='sum_in' type='submit' value='上传' onclick='loadName()'>";
        up.attr("class",'up up_hov');
    }

    function clear_fun(){
        let back_sty = $(".img_back_hov");
        let show_sty = $(".img_show_hov");
        let imgs_sty = $(".img_hov");
        back_sty.attr('class',"img_back");
        show_sty.attr('class','img_show');
        imgs_sty.attr('class', 'img');
        imgs_sty.attr('onclick','img_fun()');
        let show_hov_sty = document.getElementsByClassName("img_show")[0];
        let img_hov_sty = document.getElementsByClassName("img")[0];
        show_hov_sty.style.height = hh/4 + "px";
        show_hov_sty.style.width = ww/4 + "px";
        img_hov_sty.style.height = hh/3 + "px";
        img_hov_sty.style.width = ww/3 + "px";
        let back_up = $("#back_up");
        let new_up = $("#new_up");
        back_up.html("");
        back_up.attr('class','back_up');
        document.getElementById("new_up").innerHTML="";
        new_up.attr("class",'new_up');
    }
//******************************************************************
    function submitInfo() {
        let nickname = $("#nickname").val();
        let text = $("#text").text();
        let gender = $("input:radio:checked").val();
        let date = $("#date").val();
        let data={"nickname":nickname,"signature":text,"gender":gender,"birthday":date,"id":${PUserInfo[0].id}};
        // 将json对象转为json字符串
        var json = JSON.stringify(data);
        $.ajax({
            url: "nick",
            type: "post",
            data: {"data": json},
            success: function (data) {
                if (data === 0){
                    alert("提交失败。请稍后再试。");
                }else {
                    window.location.reload();
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
