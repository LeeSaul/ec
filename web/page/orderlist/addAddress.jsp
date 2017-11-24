<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/18
  Time: 17:36
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
    <title>增加收货地址页</title>
    <base href="<%= basePath%>">
</head>
<body>
<form action="add_address.do" method="get">
    <input type="text" name="province">省 <br />
    <input type="text" name="city">市<br />
    <input type="text" name="county">区<br />
    <input type="text" name="road">街道<br />
    <input type="text" name="addressPhone">手机号<br />
    <input type="text" name="addressReceiver">收货人<br />
    <input type="submit" value="确定添加">
</form>
</body>
</html>
