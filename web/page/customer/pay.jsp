<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/18
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                contextPath + "/";
    %>
    <title>支付页面</title>
    <base href="<%=basePath%>">
    <script src="js/jquery-min.js">
    </script>
    <script>
        function checkPass() {
            var pass=$("#pass").val();
            if (pass.length==0){
                $("#checkPass").text("密码不能为空");
            }else {
                $("#checkPass").text("");
            }
        }
        function check() {
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
<h1>${sessionScope.info}</h1>
<form action="pay.do">
    总金额${requestScope.totalMoney}
    <input type="text" name="totalMoney" value="${requestScope.totalMoney}" hidden="hidden">
    <input type="text" name="orderListId" value="${requestScope.orderListId}" hidden="hidden">
    请输入支付密码<input type="password" name="password" id="pass" onblur="checkPass()"><span id="checkPass"></span>
    <input type="submit" value="确认支付" onclick="return check()">
</form>
</body>
</html>
