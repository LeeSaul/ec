<%@ page import="com.ls.entity.ProductInfo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/12
  Time: 20:07
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
    <title>详细信息</title>
    <base href="<%= basePath%>">
</head>
<body>
<%
    ProductInfo productInfo= (ProductInfo) request.getAttribute("productInfo");

%>
<p>商品名<%= productInfo.getProduct().getProductName()%></p>
<p>商品价格<%= productInfo.getProduct().getProductPrice()%></p>
<p>商品类型<%= productInfo.getProduct().getProductType()%></p>
<p>商品说明<%= productInfo.getProductDetail().getProductCaption()%></p>
小图<img src="<%= productInfo.getProductDetail().getSmallImage()%>">
大图<img src="<%= productInfo.getProductDetail().getBigImage()%>">
</body>
</html>
