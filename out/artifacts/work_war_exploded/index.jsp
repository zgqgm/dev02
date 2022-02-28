<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/20
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
    <title>首页</title>
    <script src="js/jquery-1.8.3.min.js"></script>
  </head>
  <style>
    /* 清除默认样式 */
    *{margin:0;padding:0}
    li{list-style:none}
    img{vertical-align:top;border:none}

    .main{
      color: black;
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
    .after_nav{
      height: 50px;
      width: 150px;
      position: absolute;
      margin-left: 1102px;
      line-height: 50px;
    }
    .login_register,.logon_out,.code_out{
      margin-top: -700px;
      margin-left: -966.75px;
      width: 500px;
      height: 37.5rem;
      background-color: rgba(0,0,0,0.5);
      position: absolute;
      float: left;
      display: inline-block;
    }
    .login_register{
      z-index: 1;
    }
    .logon_out{
      z-index: 2;
    }
    .code_out{
      z-index: 3;
    }
    .logout_div,.list_ul>li,.list_li_onCil{
      height: 37px;
      line-height: 37px;
    }
    .list_li_onCil{
      background-color: lightgray;
      cursor: pointer;
    }
    .out{
      position: absolute;
      float: right;
      margin-top: 12px;
      margin-left: 457px;
      width: 30px;
      height: 1.25rem;
      background-color: rgba(0,0,0,0.5);
      color: white;
      cursor: pointer;
    }
    .back_go_1,.back_go_2{
      position: absolute;
      float: right;
      margin-top: 12px;
      margin-left: 10px;
      width: 30px;
      height: 1.25rem;
      background-color: rgba(0,0,0,0.5);
      cursor: pointer;
      color: white;
    }
    .rim,.go,.code_go{
      width: 13.625rem;
      height: 1.625rem;
      margin-top: -26px;
    }
    .main_from{
      position: absolute;
      margin-top: 6.5rem;
      margin-left: 6.5rem;
    }

    .input_div{
      margin-top: 1.625rem;
    }
    .input_dutton{
      margin-top: 2.5625rem;
      width: 4.25rem;
      height: 2.25rem;
      font-size: 1.25rem;
      font-weight: 400;
    }
    .code_dutton{
      text-align: center;
      width: 4.25rem;
      height: 1.9rem;
      line-height: 1.9rem;
      position: absolute;
      margin-top: -31px;
      margin-left: 152px;
      font-size: 1.25rem;
      font-weight: 400;
      background-color: lightgrey;
      cursor: pointer;
    }
    .Verify_div{
      margin-top: 1.25rem;
      display: inline-block;
    }
    .Verify_input{
      margin-top: 0rem;
      margin-left: 0rem;
      width: 3.25rem;
      height: 2.25rem;
      font-weight: 600;
    }
    caption{
      font-size: 1.875rem;
    }
    .logon_div{
      margin-top: 2.25rem;
      display: inline-block;
    }
    .logon_input{
      margin-top: 0rem;
      margin-left: 0rem;
      width: 3.25rem;
      height: 2.25rem;
      font-weight: 600;
    }
    .username_after,.password_after,.confirm_after,.name_after{
      position: absolute;
      margin-top: 28px;
      margin-left: -200px;
    }
    .back_div{
      width: 100%;
      height: 51.5rem;
      position: absolute;
      float: left;
      margin-top: -850px;
      margin-left: 0px;
      z-index: 0;

    }
    #nav{
      height: 48px;
      width: 100%;
      margin-top: 0px;
      margin-left: 0px;
      float: left;

    }
    .list_ul{
      background-color: #fff;
      position: absolute;
      margin: 58px 0px 0px 0;
      width: 150px;
      display: none;
      z-index: 5;
    }
    .logout_div{
      border-top: 1px solid;
    }
    .checkbox_tf{
      position: absolute;
      top: 173px;
      left: 20px;
    }
    #times{
      display: inline-block;
      color: red;
      text-align: right;
      width: 14px;
      font-weight: 800;
    }
    .code_dutton_pro{
      font-size: 12px;
      cursor: none;
      pointer-events: none;
    }
    #alertCode{
      width: 200px;
      height: 190px;
      position: absolute;
      border-radius: 50%;
      margin-top: -234px;
      margin-left: 343px;
      background-color: #3b59e5;
      border: 1px solid;
      z-index: 4;
    }
    #alertCode_1{
      background-color: white;
      display: inline-block;
      width: 179px;
      height: 155px;
      border-radius: 50%;
      position: absolute;
      top: 35px;
      left: 10px;
      border: 1px solid;
    }
    #alertCode_2{
      position: relative;
      top: 50px;
      left: 0px;
      background-color: #c40101;
      width: 23px;
      height: 23px;
      line-height: 40px;
      text-align: center;
      border-radius: 50%;
      font-size: 14px;
      z-index: 2;
      border: 1px solid;
      display: inline-block;
      cursor: pointer;
    }
    .l_eyes{
      position: absolute;
      width: 30px;
      height: 47px;
      border-radius: 49%;
      background: white;
      left: 67px;
      top: 10px;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,5deg);
      border: 1px solid;
      z-index: 5;
    }
    .r_eyes{
      position: absolute;
      width: 30px;
      height: 47px;
      border-radius: 49%;
      background: white;
      left: 100px;
      top: 10px;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,-10deg);
      border: 1px solid;
      z-index: 5;
    }
    .l_out{
      position: relative;
      width: 10px;
      height: 15px;
      background-color: black;
      border-radius: 50%;
      top: 22px;
      left: 6px;
    }
    .r_out{
      position: relative;
      width: 10px;
      height: 15px;
      background-color: black;
      border-radius: 50%;
      top: 22px;
      left: -6px;
    }
    .l_inn{
      position: relative;
      width: 6px;
      height: 8px;
      background-color: white;
      border-radius: 50%;
      top: 4px;
      left: 2px;
    }
    .r_inn{
      position: relative;
      width: 6px;
      height: 8px;
      background-color: white;
      border-radius: 50%;
      top: 4px;
      left: -2px;
    }
    .nos{
      width: 5px;
      height: 7px;
      border-radius: 50%;
      position: relative;
      background-color: white;
      top: 3px;
      left: 6px;
    }
    .mouth_1{
      height: 76px;
      width: 0px;
      position: absolute;
      margin-left: 88px;
      margin-top: 39px;
      border-left: 1px solid;
    }
    .mouth_2{
      height: 76px;
      width: 94px;
      position: absolute;
      margin-left: 41px;
      margin-top: 39px;
      border-bottom: 3px solid;
      border-bottom-left-radius: 100%;
      border-top-left-radius: 88%;
      border-bottom-right-radius: 100%;
    }
    .hz_1{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 145px;
      margin-top: 16px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,80deg);
    }
    .hz_2{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 35px;
      margin-top: 14px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,-80deg);
    }
    .hz_3{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 35px;
      margin-top: 38px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,-90deg);
    }
    .hz_4{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 145px;
      margin-top: 38px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,-90deg);
    }
    .hz_5{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 35px;
      margin-top: 62px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,-101deg);
    }
    .hz_6{
      height: 65px;
      width: 0px;
      position: absolute;
      margin-left: 142px;
      margin-top: 62px;
      border-left: 1px solid;
      transform-origin: 50% 50%;
      transform: rotate3d(0,0,1,101deg);
    }
    .text_code{
      width: 124px;
      height: 24px;
      position: relative;
      top: 125px;
      left: 2px;
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
  <body>
  <div class="main" align="center" style="width: 100%; height: 51.5rem; background-color: mediumspringgreen;">
    <div id="nav" style="background-color: black">
      <div class="after_nav">
        <div class="nav_sum" onmouseleave="nav_sum_out()" onmouseenter="nav_sum_over()">
          <c:if test="${sessionScope.face != undfind}">
            <img src="${sessionScope.face}" id="headimg">
          </c:if>
          <span <c:if test="${sessionScope.face != undfind}">class="click_input"</c:if> <c:if test="${sessionScope.face == undfind}">class="click_input_1"</c:if>  onclick="login_register_fun()">登录/注册</span>
          <ul class="list_ul">
            <li class="list_li">
              <div onclick="personfun()">个人中心</div>
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
          <li class="list_lis" onclick="window.location.href='showMenu'">导航分类管理
            <ul class="list_ul_l">
              <li class="list_lis_l" onclick="window.location.href='showMenu'">全部</li>
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
    <div class="back_div" onclick="all_out()"></div>
    <div class="login_register" >
      <div class="out" onclick="out_div_1()">×</div>
      <form class="main_from">
        <table align="center">
          <caption>登录</caption>
          <tr>
            <td style="font-size: 1.5rem;">
              <div class="input_div">账号</div>
            </td>
            <td>
              <div class="input_div"><input id="userId" class="rim" type="text" name="username" autofocus="autofocus" /></div>
            </td>
          </tr>
          <tr>
            <td style="font-size: 1.5rem;">
              <div class="input_div">密码</div>
            </td>
            <td>
              <div class="input_div"><input id="userWord" class="rim" type="password" name="password"/></div>
            </td>
          </tr>
          <tr align="center">
            <td colspan="2">
              <div class="checkbox_tf">
                <input type="checkbox" class="tf_checkbox">
                <span>记住我</span>
              </div>
              <input class="input_dutton" onclick="login_submit()" type="button" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;
              <input class="input_dutton" type="reset" value="重置" />
            </td>
          </tr>
        </table>
        <div>
          <div class="Verify_div">忘记密码了？验证码登录</div>
          <input class="Verify_input" onclick="code_div()" type="button" value="验证码"/>
        </div>
        <div>
          <div class="logon_div">没有账号？点击注册</div>
          <input class="logon_input" type="button" onclick="logon_div()" value="注册"/>
        </div>
      </form>
    </div>
    <div class="logon_out">
      <div class="back_go_1" onclick="back_go_main()">←</div>
      <div class="out" onclick="out_div_2()">×</div>
      <form class="main_from">
        <table align="center">
          <caption>注册</caption>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">账号</div></td>
            <td>
              <div class="input_div">
                <input class="go" id="username" type="text" name="username" oninput="account()">
                <i class="username_after"></i>
              </div>
            </td>
          </tr>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">密码</div></td>
            <td>
              <div class="input_div">
                <input class="go" id="password" type="password" name="password" oninput="Password()">
                <i class="password_after"></i>
              </div>
            </td>
          </tr>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">确认密码</div></td>
            <td>
              <div class="input_div">
                <input class="go" id="confirm" type="password" name="password1" oninput="confirm()">
                <i class="confirm_after"></i>
              </div>
            </td>
          </tr>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">验证码</div></td>
            <td>
              <div class="input_div">
                <input class="code_go" id="code_id_1" type="text" style="width: 131px" name="code" onchange="ccdo()">
                <div class="code_dutton" onclick="code_button()" >验证码</div>
              </div>
            </td>
          </tr>
          <tr align="center">
            <td colspan="2">
              <input type="button" class="input_dutton" value="注册" onclick="register()">
              <input type="reset" class="input_dutton" value="重置" onclick="reset()">
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div id="alertCode">
      <div class="l_eyes"><div class="l_out"><div class="l_inn"></div></div></div>
      <div class="r_eyes"><div class="r_out"><div class="r_inn"></div></div></div>
      <div id="alertCode_1">
        <div class="mouth_1"></div>
        <div class="mouth_2"></div>
        <div class="hz_1"></div>
        <div class="hz_2"></div>
        <div class="hz_3"></div>
        <div class="hz_4"></div>
        <div class="hz_5"></div>
        <div class="hz_6"></div>
      </div>
      <div id="alertCode_2" onclick="textOut()"><div class="nos"></div></div>
      <div class="text_code"></div>
    </div>
    <div class="code_out">
      <div class="back_go_2" onclick="back_go_main()">←</div>
      <div class="out" onclick="out_div_3()">×</div>
      <form class="main_from">
        <table align="center">
          <caption>登录</caption>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">账号</div></td>
            <td>
              <div class="input_div">
                <input class="code_go" id="code_username" type="text" name="username">
                <i class="name_after"></i>
              </div>
            </td>
          </tr>
          <tr>
            <td style="font-size: 1.5rem;"><div class="input_div">验证码</div></td>
            <td>
              <div class="input_div">
                <input class="code_go" id="code_id" style="width: 131px" type="text" name="code" >
                <div class="code_dutton" onclick="code_button()" >验证码</div>
              </div>
            </td>
          </tr>
          <tr align="center">
            <td colspan="2">
              <input type="button" class="input_dutton" value="登录" onclick="checking()">
              <input type="reset" class="input_dutton" value="重置" onclick="reset()">
            </td>
          </tr>
        </table>
      </form>
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
    var KUsername = "";
    var KPassword = "";
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
      if (nameArr==="username"){
        KUsername=arrName[1];
      }
      if (nameArr==="password"){
        KPassword=arrName[1];
      }
    }
    function personfun() {
      window.location.href="person?name="+showName;
    }
    (function (){
      var users = $(".click_input");
      if (nameID !== ""){
        users.html(showName);
      }
      if (KUsername !==""&&KPassword!==""){
        $("#userId").val(KUsername);
        $("#userWord").val(KPassword);
        document.getElementsByClassName("tf_checkbox")[0].checked=true;
        $("#code_username").val(KUsername)
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

    var tf = true;

    function logon_div(){
      var elem1 = document.getElementsByClassName("logon_out")[0];
      var elemD2 = document.getElementsByClassName("login_register")[0];
      elem1.style.marginTop='20px';
      elemD2.style.marginTop='-700px';
    }
    function code_div(){
      var elem1 = document.getElementsByClassName("code_out")[0];
      var elem2 = document.getElementsByClassName("login_register")[0];
      elem1.style.marginTop='20px';
      elem2.style.marginTop='-700px';
    }
    function all_out(){
      out_div_1();
      out_div_2();
      out_div_3();
    }
    function out_div_1(){
      var elem = document.getElementsByClassName("login_register")[0];
      var eleDm=document.getElementsByClassName("back_div")[0];
      elem.style.marginTop='-700px';
      eleDm.style.marginTop='-850px';
    }
    function out_div_2(){
      var elem = document.getElementsByClassName("logon_out")[0];
      var eleDm=document.getElementsByClassName("back_div")[0];
      elem.style.marginTop='-700px';
      eleDm.style.marginTop='-850px';
    }
    function out_div_3(){
      var elem = document.getElementsByClassName("code_out")[0];
      var eleDm=document.getElementsByClassName("back_div")[0];
      elem.style.marginTop='-700px';
      eleDm.style.marginTop='-850px';
    }
    function back_go_main(){
      var elem1 = document.getElementsByClassName("logon_out")[0];
      var elem2 = document.getElementsByClassName("code_out")[0];
      var elem = document.getElementsByClassName("login_register")[0];
      elem.style.marginTop='20px';
      elem1.style.marginTop='-700px';
      elem2.style.marginTop='-700px';
    }
    function login_submit(){
      var username = $("#userId").val();
      var password = $("#userWord").val();
      var http  = false;
      $.ajax({
        url:"login",
        type:"post",
        async:false,//通过同步实现ajax为js变量赋值
        data:{"username":username,"password":password},
        success:function (data) {
          if (data === "true"){
            tf = false;
            http = true;
          }else {
            alert("账号或密码输入错误，请重新输入");
          }
        }
      })
      var check = $(".tf_checkbox").prop("checked");
      if (check && !tf){
        $.ajax({
          url:"keep",
          type:"post",
          data:{"username":username,"password":password},
          success:function (data) {
          }
        })
      }else if (!tf){
        $.ajax({
          url:"logout",
          type:"get",
          data:{"llf":"true"},
          success:function (data){
          }
        })
      }
      if (http){
        window.location.href="PPage";
      }
    }
    var isUsername = false;
    var isPassword = false;
    var isConfirm = false;
    var isregister = true;
    var istf =false;
    function account(){
      var username = $("#username").val();
      var usernameInfo = $(".username_after");
      if (username === null || username === ''){
        usernameInfo.html('账号不能为空');
        usernameInfo.attr('style','color:red');
        isUsername = false;
      }else {
        $.ajax({
          url:"register",
          type:"get",
          data:{"username":username},
          success:function (data) {
            if (data !== 'false'){
              usernameInfo.html('该账号已被占用');
              usernameInfo.attr('style','color:red');
              isUsername = false;
            }else {
              usernameInfo.html('');
              usernameInfo.attr('style','color:#000');
              isUsername = true;
            }
          }
        })
      }
    }
    function Password(){
      var pass = $("#password").val();
      var passInfo = $(".password_after");
      if (pass === null || pass === ""){
        passInfo.html("密码不能为空");
        passInfo.attr('style','color:red');
        isPassword = false;
      }else {
        passInfo.html("");
        passInfo.attr('style','color:#000');
        isPassword = true;
      }
    }
    function confirm(){
      var confirmInfo = $(".confirm_after");
      var pass1 = $("#password").val();
      var pass2 = $("#confirm").val();
      if (pass1 === pass2){
        confirmInfo.html("");
        isConfirm = true;
      }else{
        confirmInfo.html("两次出入密码不同");
        confirmInfo.attr('style','color:red');
        isConfirm = false;
      }
    }
    function ccdo(){
      var code = $("#code_id_1").val();
      if (code === null || code === ""){
        alert("请先填写验证码");
        codeInput.attr('style','autofocus');
      }else {
        $.ajax({
          url:"codeLogin",
          type:"get",
          data:{"code":code},
          success:function (data) {
            if (data === '11'){
              istf =true;
            }else {
              istf = false;
            }
          }
        })
      }
    }
    function register() {
      if (isregister){
        confirm();
        Password();
        account();

      }

      if (isConfirm&&isUsername&&isPassword&&istf){
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
          url: "main",
          type: "post",
          data: {'username':username,'password':password},
          success:function (data){
            if (data === 'true'){
              window.location.href="PPage";
              isregister = false;
              alert("注册成功");
            }else {
              alert("请重新核对填写信息");
            }
          }
        })
      }else{
        alert("请重新核对填写信息");
      }

    }
    function reset(){
      $("#username").val("");
      $("#confirm").val("");
      $("#password").val("")

    }

    function code_button() {
      $.ajax({
        url:"getCode",
        type:"get",
        data:{},
        success:function (data){
          $(".text_code").html('验证码：'+data);
        }
      })
      const codetab = $(".code_dutton");
      codetab.html('请<div id="times">60</div>s后再试');
      codetab.attr('class','code_dutton code_dutton_pro');
      let count = 60;
      const timeF = setInterval(function () {
        count--;
        codetab.html('请<div id="times">'+count+'</div>s后再试');
        if (count === 0) {
          clearInterval(timeF);
          codetab.html("验证码");
          codetab.attr('class', 'code_dutton');
        }
      }, 1000);
      let textCode = document.getElementById("alertCode");
      let num = -234;
      const timeT = setInterval(function () {
        num=num+16;
        textCode.style.marginTop=num+'px';
        if (num>=120) {
          clearInterval(timeT);
        }
      }, 1);
    }

    function textOut() {
      $(".text_code").html('');
      let textCode = document.getElementById("alertCode");
      let num = 120;
      const timeT = setInterval(function () {
        num=num-16;
        textCode.style.marginTop=num+'px';
        if (num<=-234) {
          clearInterval(timeT);
        }
      }, 1);
    }

    function checking() {
      var username = $("#code_username").val();
      var nameafter = $(".name_after");
      var codeInput = $("#code_id");
      var code = $("#code_id").val()
      if (username === null || username === ""){
        nameafter.html("账号不能为空");
        nameafter.attr('style','color:red');
      }else {
        nameafter.html("");
        if (code === null || code === ""){
          alert("请先填写验证码");
          codeInput.attr('style','width: 131px');
        }else {
          $.ajax({
            url:"codeLogin",
            type:"get",
            data:{"username":username,"code":code},
            success:function (data) {
              if (data === 'true'){
                tf=false;
                alert("登陆成功");
              }else {
                alert("登陆失败");
              }
            }
          })
        }
      }
    }
    if (tf && nameID === ""){
      function login_register_fun(){
        var elem = document.getElementsByClassName("login_register")[0];
        var elem1 = document.getElementsByClassName("back_div")[0];
        var num = -700;
        elem1.style.marginTop=0+'px';
        var time = setInterval(function(){
          elem.style.marginTop=num+'px';
          num=num+16;

          if(num<=20){}else{

            clearInterval(time);
          }
        },1)
      }
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
