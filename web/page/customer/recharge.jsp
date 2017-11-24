<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/20
  Time: 16:17
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
    <title>充值页面</title>
    <base href="<%= basePath%>">
    <script src="js/jquery-min.js">
    </script>
    <script>
        function check1() {
            var pass=$("#money").val();
            if (pass.length==0){
                $("#checkMoney").text("金额不能为空");
            }else if (pass<=0){
                $("#checkMoney").text("金额有误");
            }else {
                $("#checkMoney").text("");
            }
        }
        function check2() {
            var pass=$("#pass").val();
            if (pass.length==0){
                $("#checkPass").text("密码不能为空");
                return false;
            }else {
                $("#checkPass").text("");
            }
        }
    </script>
</head>
<body>
<a href="page/customer/customerIndex.jsp">首页</a><br />
<form action="recharge.do" method="post">
    请输入要充值的金额<input type="number" name="money" id="money" onblur="check1()"><span id="checkMoney"></span><br />
    支付密码<input type="password" name="password" id="pass" onblur="check2()"><span id="checkPass"></span>
    <input type="submit" value="确认充值">
</form>
</body>
</html>
