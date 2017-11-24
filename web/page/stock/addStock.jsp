<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 18:15
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
    <title>添加仓库</title>
    <base href="<%=basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">返回首页</a>
<h2>商品名：${requestScope.stockInfo.productName}</h2>
<h2>类型：${requestScope.stockInfo.productType}</h2>
<h2>价格：${requestScope.stockInfo.productPrice}</h2>
<form action="add_stock.do" method="get">
    <input type="number" name="stockNumber" min="1" value="1"> 数量
    <input type="text" name="productId" hidden="hidden" value="${requestScope.stockInfo.pId}">
    <input type="text" name="stockId" hidden="hidden" value="${requestScope.stockInfo.stockId}">
    <input type="text" name="productPrice" hidden="hidden" value="${requestScope.stockInfo.productPrice}">
    <input type="submit" value="增加">
</form>
</body>
</html>
