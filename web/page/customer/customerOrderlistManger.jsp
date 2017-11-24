<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/21
  Time: 16:41
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
    <title>订单管理界面</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/customer/customerIndex.jsp">首页</a><br />
<a href="customer_orders.view">所有订单</a>
<a href="customer_orders_status.view?status=NOT_PAY">待付款</a>
<a href="customer_orders_status.view?status=NOT_SEND">待发货</a>
<a href="customer_orders_status.view?status=NOT_CONFIRMED">待确认</a>
<a href="customer_orders_status.view?status=CONFIRMED">已完成</a>
</body>
</html>
