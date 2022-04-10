<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2021/12/22
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示</title>
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<style>
    /* 清除默认样式 */
    *{margin:0;padding:0}
    li{list-style:none}
    img{vertical-align:top;border:none}
    th,td{
        text-align: center;
    }
    .nav_f{
        height: 25px;
        width: auto;
    }
    .nav_f_input{
        position: absolute;
        margin-left: 391px;
        margin-top: 6px;
    }
    #num_show{
        background-color: red;
        color: darkgray;
        display: inline-block;
        width: 20px;
        height: 20px;
        margin-left: 451px;
        margin-top: 9px;
        border-radius: 50%;
        text-align: center;
    }

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
    .list_li div{
        text-align: center;
    }
    #student_query{
        position: relative;
        display: inline-block;
        top: -27px;
        left: 744px;
        height: 28px;
        line-height: 28px;
    }
    #sex{
        width: 63px;
        height: 22px;
        position: relative;
        top: -51px;
        left: 915px;
    }
    .cs_1{
        position: relative;
        margin-top: -76px;
        margin-left: 989px;
        width: 98px;
        height: 27px;
        line-height: 27px;
        background-color: darkgray;
        color: white;
    }
    .qs_1{
        position: relative;
        margin-top: -76px;
        height: 26px;
        line-height: 26px;
        width: 47px;
        margin-left: 1096px;
        background-color: blue;
        color: white;
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
<body style="background-color: aquamarine">
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
<div>
    <div class="nav_f">
        <input class="nav_f_input" type="button" value="批量删除" onclick='checkbox_this()'><%--onclick="change_delete()"--%>
        <span id="num_show">0</span>
        <form>
            <input type="text" placeholder="学生姓名" id="student_query">
            <div id="sex">
                <input type="radio" id="sex1" class="sex1" name="sex" value="男"><label for="sex1">男</label>
                <input type="radio" id="sex2" class="sex2" name="sex" value="女"><label for="sex2">女</label>
            </div>
            <input type="button" class="cs_1" value="清空查询条件" onclick="clear_form()">
            <input type="button" class="qs_1" value="查询" onclick="query_fun()">
        </form>
    </div>
</div>
<div align="center" style="margin-top: 56px" >
    <table align="center" border="1px">
        <tr>
            <th>
                <input type="checkbox" class="checkbox_all" onclick="checkbox_all_c()">
            </th>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th width="500px">信息</th>
            <th colspan="2">操作</th>
        </tr>

        <c:if test="${not empty pageInfo.list}">
            <c:forEach var="user" items="${pageInfo.list}">
                <tr>
                    <td><input type="checkbox" id="${user.id}" class="checkbox_class" onclick="checkbox_num(${user.id})"></td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.gender}</td>
                    <td>${user.info}</td>
                    <td >
                        <svg t="1645668109760" onclick='up_click(${user.id})' class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5508" width="30" height="30"><path d="M275.6 782c-8.5 0-16.6-3.4-22.6-9.4l-138-138c-12.5-12.5-12.5-32.8 0-45.3l398.6-398.6c8.9-8.9 33.5-29.5 71.2-29.5 26.9 0 52.2 10.5 71.2 29.5l40.9 40.9c39.2 39.2 39.2 103.1 0 142.4L654 417C538.2 532.7 418.5 652.3 298.2 772.6c-6 6-14.1 9.4-22.6 9.4z m-92.7-170l92.7 92.7c112.7-112.7 224.7-224.6 333.2-333l42.9-42.9c14.3-14.3 14.3-37.7 0-51.9L610.8 236c-6.9-6.9-16.1-10.7-26-10.7-14.5 0-24.2 8.9-26 10.7L182.9 612z" p-id="5509"></path><path d="M96.7 822.9c-8.4 0-16.6-3.3-22.6-9.4-8.1-8.1-11.2-19.9-8.3-30.9l47.6-177.5c3-11 11.6-19.7 22.6-22.6 11-3 22.8 0.2 30.9 8.3l130 129.9c8.1 8.1 11.2 19.9 8.3 30.9-3 11-11.6 19.7-22.6 22.6L105 821.8c-2.8 0.7-5.5 1.1-8.3 1.1z m64.2-147.7L142 745.6l70.5-18.9-51.6-51.5zM607.2 419.2c-8.3 0-16.6-3.2-22.8-9.6L463.1 286.1c-12.4-12.6-12.2-32.9 0.4-45.3 12.6-12.4 32.9-12.2 45.3 0.4L630 364.8c12.4 12.6 12.2 32.9-0.4 45.3-6.2 6-14.3 9.1-22.4 9.1zM922.9 813.3H402.1c-17.7 0-32-14.3-32-32s14.3-32 32-32h520.8c17.7 0 32 14.3 32 32s-14.3 32-32 32z" p-id="5510"></path><path d="M922.9 677.3H599.6c-17.7 0-32-14.3-32-32s14.3-32 32-32h323.3c17.7 0 32 14.3 32 32s-14.3 32-32 32z" p-id="5511"></path><path d="M921.9 543.8H725.6c-17.7 0-32-14.3-32-32s14.3-32 32-32h196.3c17.7 0 32 14.3 32 32s-14.3 32-32 32z" p-id="5512"></path></svg>
                    </td>
                    <td>
                        <svg onclick='del_click(${user.id})' t="1645667728540" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3885" width="30" height="30"><path d="M202.666667 256h-42.666667a32 32 0 0 1 0-64h704a32 32 0 0 1 0 64H266.666667v565.333333a53.333333 53.333333 0 0 0 53.333333 53.333334h384a53.333333 53.333333 0 0 0 53.333333-53.333334V352a32 32 0 0 1 64 0v469.333333c0 64.8-52.533333 117.333333-117.333333 117.333334H320c-64.8 0-117.333333-52.533333-117.333333-117.333334V256z m224-106.666667a32 32 0 0 1 0-64h170.666666a32 32 0 0 1 0 64H426.666667z m-32 288a32 32 0 0 1 64 0v256a32 32 0 0 1-64 0V437.333333z m170.666666 0a32 32 0 0 1 64 0v256a32 32 0 0 1-64 0V437.333333z" p-id="3886"></path></svg>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <tr align="center">
            <td colspan="8"><input type="button" onclick="add_click()" value="添加"></td>

        </tr>
    </table>
    <form action="PPage" method="get">
        <table align="center">
            <tr>
                <td>
                    <c:if test="${pageInfo.pageNo == 1}">
                        <a style="color: red">首页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != 1}">
                        <a class="mya" href="PPage?pageNo=1">首页</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${pageInfo.pageNo == 1}">
                        <a style="color: red">上一页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != 1}">
                        <a class="mya" href="PPage?pageNo=${pageInfo.pageNo - 1}">上一页</a>
                    </c:if>
                </td>
                <c:forEach var="pageNo" step="1" begin="1" end="${pageInfo.pageCount}">
                    <td>
                        <c:if test="${pageNo == pageInfo.pageNo}">
                            <input disabled type="button" value="${pageNo}">
                        </c:if>

                        <c:if test="${pageNo != pageInfo.pageNo}">
                            <input class="myin" type="button" onclick="pageBut(${pageNo})" value="${pageNo}">
                        </c:if>

                    </td>
                </c:forEach>
                <td>
                    <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                        <a style="color: red">下一页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                        <a class="mya" href="PPage?pageNo=${pageInfo.pageNo + 1}">下一页</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                        <a style="color: red">尾页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                        <a class="mya" href="PPage?pageNo=${pageInfo.pageCount}">尾页</a>
                    </c:if>
                </td>
                <td>共${pageInfo.totalCount}条内容</td>
                <td>共${pageInfo.pageCount}页</td>
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
    function add_click(){
        window.location.href="formlofo.jsp";
    }
    function del_click(id){
        if (confirm('您是否确认删除？') === true) {
            $.ajax({
                url: "delete",
                type: "get",
                data: {"id": id},
                success: function (data) {
                    if (data !== 0) {
                        alert("删除成功"); window.location.href="PPage?pageNo=${pageInfo.pageNo}";
                    } else {
                        alert("网络拥堵，请稍后再试");
                    }
                }
            })

        }
    }
    function up_click(id){
        $.ajax({
            url:"select",
            type:"get",
            data:{"id":id},
            success:function (data){
                if (data === null){
                    alert("查无此人");
                }else {
                    window.location.href="upData.jsp?id="+id;
                }
            }
        })

    }
    var count = 0;
function checkbox_num(id) {
    var idd = "#"+id;
    var idValue = $(idd).prop('checked');
    if (idValue === true){
        count++;
    }else {
        count--;
    }
    $("#num_show").html(count);
    if (count==checkNum.length){
        document.getElementsByClassName("checkbox_all")[0].checked=true;
    }else {
        document.getElementsByClassName("checkbox_all")[0].checked=false;
    }
}

    var checkNum = document.getElementsByClassName("checkbox_class");
    var ids = "";
function checkbox_all_c(){
    var tfcac = $(".checkbox_all").prop('checked');
    if (tfcac === true){
        $("#num_show").html(checkNum.length);
        count=checkNum.length;
        for (var num = 0;num<checkNum.length;num++){
            checkNum[num].checked=true;

        }
    }else {
        $("#num_show").html(0);
        count = 0;
        for (var num = 0;num<checkNum.length;num++){
            checkNum[num].checked=false;

        }
    }

}

function checkbox_this(){
    if (count!==0&&confirm('您是否确认删除？\n删除后将无法恢复!') === true){
        var idlist = "";
        for (var num = 0;num<checkNum.length;num++){
            var eml = checkNum[num].id;
            var idd = "#"+eml;
            var idValue = $(idd).prop('checked');
            if (idValue === true){
                idlist+=eml+" ";
            }
        }

        $.ajax({
            url: "delete",
            type: 'get',
            data: {"idList":idlist},
            success:function (data) {
                if (data === "0") {
                    alert("删除成功");
                    window.location.href="PPage?pageNo=${pageInfo.pageNo}";
                } else {
                    alert("编号"+data+"由于某些原因，造成删除失败。\n请稍后再试!");
                }
            }
        })
    }
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
    let tiaojian ="";
    let gender = "";
    (function (){
        //const res ={};
        const search = window.location.search.substr(1);//截取？后所有内容
        search.split('&').forEach(item => {//拆分成数组，并遍历
            const arr = item.split('=');

            if (arr[0] === "tiaojian"){
                tiaojian=decodeURI(arr[1]);//URL参数解码decodeURI（）
            }
            if (arr[0] === "gender"){
                gender=decodeURI(arr[1]);
            }
        });

    })();
    function query_fun() {
        let tiaojian = $("#student_query").val();
        let gender = $("input:checked").val();
        if (tiaojian === "" && gender ===undefined){
            alert("查询条件不能为空");
        }else {
            window.location.href="PPage?pageNo=${pageInfo.pageNo}&tiaojian="+tiaojian+"&gender="+gender;
        }

    }
    (function () {
       if (gender === "男"){
            $(".sex1").attr("checked",true);
        }
        if (gender === "女"){
            $(".sex2").attr("checked",true);
        }
        $("#student_query").val(tiaojian);
    })();

    let aH=document.getElementsByClassName("mya");
    for (let i =0;i<aH.length;i++){
        let sts=aH[i].getAttribute('href')+"&tiaojian="+tiaojian+"&gender="+gender;
        aH[i].href=sts;
    }
    function pageBut(pagNo) {
        window.location.href="PPage?pageNo="+pagNo+"&tiaojian="+tiaojian+"&gender="+gender;
    }
    function clear_form(){
        $("#student_query").val("");
        $("input:checked").attr("checked",false);

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
