<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2022/2/25
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>菜单信息</title>
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
    .list_lis_l{
      height: 31px;
      line-height: 31px;
      text-align: center;
    }
    /****************************************************/
    .m_button{
      position: relative;
      display: inline-block;
      height: 23px;
      width: 74px;
      background-color: yellow;
      line-height: 25px;
      font-size: 13px;
      border: 2px solid darkgray;
      cursor:pointer;
      text-align: center;
    }
    .list_lis_L_onCil{
      background-color: #ababab;
      color: red;
    }
    .list_ul_ls{
      display: none;
      z-index: 2;
      position: relative;
      float: left;
      width: 111px;
      height: 155px;
      font-size: 18px;
      background-color: white;
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
<body style="background-color: cyan">
<div id="nav" style="background-color:black;">
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
<div class="from_div">
  <form  >
    <table align="center">
      <caption><h1 align="center" style="color: chartreuse">添加菜单信息</h1></caption>
      <tr>
        <td>餐名</td>
        <td><input id="name" type="text" name="name"></td>
      </tr>
      <tr>
        <td>分类</td>
        <td>
          <div class="m_button" onclick="button_ls()" onmouseleave="ul_bian()"><label id="mefood">菜单类型</label>
            <svg t="1645756382177" style="top: 3px;position: relative;float: right;" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="760" width="15" height="15">
              <path d="M723.84 384c10.688 0 21.056 3.008 29.056 8.448 18.368 12.48 20.224 34.112 4.16 48.32l-211.84 187.52-4.16 3.2c-18.304 12.48-46.208 11.072-62.272-3.2l-211.84-187.52A30.208 30.208 0 0 1 256 418.24C256 399.296 275.776 384 300.16 384h423.68z" fill="#000000" p-id="761" >
              </path>
            </svg>
            <ul class="list_ul_ls">
              <li class="list_lis_l">美食</li>
              <li class="list_lis_l">甜点饮品</li>
              <li class="list_lis_l">超市便利</li>
              <li class="list_lis_l">蔬菜水果</li>
              <li class="list_lis_l">急救买药</li>
            </ul>
          </div>
          <input id="cname" type="text" name="cname"></td>
      </tr>
      <tr >
        <td colspan="2" align="center">
          <input type="button" name="submit" onclick="button_add()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="reset" name="reset" value="重置">
        </td>
      </tr>
    </table>
  </form>
</div>
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
    var nameArr = arrName[0].replace(/(^\s*)|(\s*$)/g,"");//去除多余的空格！！！！！！！！！
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
  function button_add(){

    let name = $("#name").val();
    let cname = $("#cname").val();
    var data = {"name": name, "cut": cname};

    // 将json对象转为json字符串
    var json = JSON.stringify(data);
    $.ajax({
      url: "addme",
      type: "post",
      data: {"data": json},
      success: function (data) {
        if (data === 0){
          alert("添加错误。原因可能是重复添加。");
        }else {
          window.location.href="showMenu";
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
  //**********************************************
  let emLies = document.getElementsByClassName("list_ul_ls")[0];
  function button_ls() {
    let emLies1 = document.getElementsByClassName("list_lis_l");
    emLies.style.display="inline-block";
    for (let i = 0; i < emLies1.length; i++) {
      emLies1[i].onmousemove=function(){
        this.setAttribute("class","list_lis_l list_lis_L_onCil");
        sumb = document.getElementsByClassName("list_lis_L_onCil")[0];
        sumb.onclick=function () {
          cutname = sumb.innerHTML;
          $("#cname").val(cutname);
          $("#mefood").html(cutname);
        }
      }
      emLies1[i].onmouseout=function(){
        this.setAttribute("class","list_lis_l");

      }
    }
  }
  function ul_bian() {
    emLies.style.display="none";
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
</body>
</html>
