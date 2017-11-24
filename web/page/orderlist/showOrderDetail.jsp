<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/20
  Time: 9:35
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
    <title>订单详情页</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/customer/customerIndex.jsp">返回首页</a>
<img src="${order.smallImage}" /><br />
商品名：${requestScope.orderDetail.productName}<br />
价格：${requestScope.orderDetail.productPrice}<br />
商品数量：${requestScope.orderDetail.productCount}<br />
商品状态：${requestScope.orderDetail.itemOrderStatus}<br />
订单状态：${requestScope.orderDetail.orderStatus}<br />
创建时间：${requestScope.orderDetail.orderCreateTime}<br />
订单id：${requestScope.orderDetail.orderListId}<br />
收货地址：
${requestScope.orderDetail.province}
${requestScope.orderDetail.city}
${requestScope.orderDetail.county}
${requestScope.orderDetail.addressPhone}
收货人：
${requestScope.orderDetail.addressReceiver}
</body>
</html>
