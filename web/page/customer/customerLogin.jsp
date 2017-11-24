<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 15:16
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
    <title>用户登录界面</title>
    <base href="<%= basePath%>">
    <style>
        .bd1{
            background-image: url("images/bg.jpg");
            background-repeat:no-repeat;
            background-size:100% 100%;
            background-attachment:fixed;
        }
        .div1 {
            margin: 11% 37%;
            width: 23%;
        }
    </style>
    <script src="js/jquery-min.js">
    </script>
    <script>
        function checkName() {
            var customerName=$("#customerName").val();
            console.log(customerName);
            console.log(customerName.length);
            if (customerName.length==0){
                customerName=$("#check1").text('用户名为空');
            }else {
                customerName=$("#check1").text('');
            }
        }
        function checkPass() {
            var customerPass=$("#customerPass").val();
            if (customerPass.length==0){
                customerPass=$("#check2").text('密码为空');
            }else {
                customerPass=$("#check2").text('');
            }
        }
        function check3() {
            var customerName=$("#customerName").val();
            var customerPass=$("#customerPass").val();
            if (customerName.length==0){
                customerName=$("#check1").text('用户名为空');
                return false;
            }else {
                customerName=$("#check1").text('');
                if (customerPass.length==0){
                    customerPass=$("#check2").text('密码为空');
                    return false;
                }else {
                    customerPass=$("#check2").text('');
                }
            }
        }
    </script>
</head>
<body  class="bd1">
<div class="div1">
    <h2>${requestScope.info}</h2>
    <form action="customer_login.do" method="post">
        用户名：<input type="text" id="customerName" name="customerName" onblur="checkName()"><span id="check1"></span><br/><br/>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" id="customerPass" name="customerPassword" onblur="checkPass()"><span id="check2"></span><br/><br/>
        <input type="checkbox" value="on" name="isKeep">是否记住密码
        &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" onclick="return check3()">
    </form>
    <a href="page/customer/customerRegister.jsp" >注册</a>
</div>
</body>
</html>
