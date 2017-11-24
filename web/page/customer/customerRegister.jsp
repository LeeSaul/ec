<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/14
  Time: 16:42
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
    <title>用户注册</title>
    <base href="<%= basePath%>">
    <script src="js/jquery-min.js">
    </script>
    <script>
        var xmlhttp;
        var myData;
        function checkCustomerName() {
            var customerName=$("#customerName").val();
            console.log(customerName.length);
            if (customerName.length<3){
                $("#check").text("用户名长度至少为3");
                return;
            }else {
                $("#check").text("")
            }
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.open("GET","check_customerName.do?customerName="+document.getElementsByName("customerName")[0].value,true);
            xmlhttp.send();
            xmlhttp.onreadystatechange=result;

        }
        function result() {
            if (xmlhttp.readyState == 4 && xmlhttp.status==200)
            {
                myData=xmlhttp.responseText;
                console.log(myData)
                show(myData);
            }
        }
        function show(myData) {
            if (myData.toUpperCase().trim() =="EXIST"){
                document.getElementById("check").innerHTML="已存在";
            }else {
                document.getElementById("check").innerHTML="√";
            }

        }
        function checkPass() {
            var password=$("#password").val();
            console.log(password.length);
            if (password.length<5){
                $("#check2").text("密码长度至少为5");
                return;
            }else {
                $("#check2").text("")
            }
        }
        function checkPass2() {
            var password=$("#password").val();
            var password2=$("#password2").val();
            if (password!=password2){
                $("#check3").text("密码不一致");
                return;
            }else {
                $("#check3").text("")
            }
        }
        function check(){
            var customerName=$("#customerName").val();
            var password=$("#password").val();
            var password2=$("#password2").val();
            if (customerName.length<3){
                $("#check").text("用户名长度至少为3");
                return false;
            }else {
                $("#check").text("");
                console.log(password.length);
                if (password.length<5){
                    $("#check2").text("密码长度至少为5");
                    return false;
                }else {
                    $("#check2").text("")
                    if (password!=password2){
                        $("#check3").text("密码不一致");
                        return false;
                    }else {
                        $("#check3").text("")
                    }
                }
            }
        }
    </script>
    <style>
        .bd1{
            background-image: url("images/bg.jpg");
            background-repeat:no-repeat;
            background-size:100% 100%;
            background-attachment:fixed;
        }
        .div1 {
            margin: 11% 37%;
            width: 27%;
        }
    </style>
</head>
<body class="bd1">
<div class="div1">
    <a href="welcome.jsp">返回首页</a>
    <h2>${requestScope.info}</h2>
    <form action="customer_register.do" method="post">
        用户名<input type="text" name="customerName" id="customerName" minlength="3" maxlength="8" onblur="checkCustomerName()">
        <span id="check"></span><br/><br/>
        密&nbsp;&nbsp;&nbsp;码<input type="password" id="password" name="customerPassword" onblur="checkPass()"><span id="check2"></span><br/><br/>
        确认密码<input type="password" id="password2" name="customerPassword2" onblur="checkPass2()"><span id="check3"></span><br/><br/>
        <input type="submit" value="注册" onclick="return check()">
    </form>
    <a href="page/customer/customerLogin.jsp">登录</a>
</div>
</body>
</html>
