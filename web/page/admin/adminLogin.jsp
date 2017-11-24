<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/11
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <title>管理员登录界面</title>
    <base href="<%= basePath%>">
    <style>
        .bd1{
            background-image: url("images/bg.jpg");
            background-repeat:no-repeat;
            background-size:100% 100%;
            background-attachment:fixed;
        }
        .div1 {
            margin: 13% 33%;
            width: 26%;
            height: 20%;
            border: solid #7a5b5b;
            border-radius: 11px;
        }
    </style>
    <script src="js/jquery-min.js">
    </script>
    <script>
        function checkName() {
            var name=$("#name").val();
            console.log(name);
            console.log(name.length);
            if (name.length==0){
                $("#check1").text('用户名为空');
            }else {
                $("#check1").text('');
            }
        }
        function checkPass() {
            var pass=$("#pass").val();
            if (pass.length==0){
                $("#check2").text('密码为空');
            }else {
                $("#check2").text('');
            }
        }
        function check3() {
            var name=$("#name").val();
            var pass=$("#pass").val();
            if (name.length==0){
                $("#check1").text('用户名为空');
                return false;
            }else {
                $("#check1").text('');
                if (pass.length==0){
                    $("#check2").text('密码为空');
                    return false;
                }else {
                    $("#check2").text('');
                }
            }
        }
    </script>
</head>
<body  class="bd1">
<%
    String info = (String) request.getAttribute("info");
    if (info!=null){
        out.println("<h2>"+info+"</h2>");
    }
%>
<div class="div1">
    <form action="admin.login" method="get">
        用户名：<input type="text" name="adminName" id="name" onblur="checkName()"><span id="check1"></span><br />
        密码：<input type="password" name="adminPassword" id="pass" onblur="checkPass()"><span id="check2"></span><br />
        <input type="checkbox" value="on" name="isKeep">是否记住密码 <br />
        <input type="submit" value="登录" onclick="return check3()">
    </form>
</div>
</body>
</html>
