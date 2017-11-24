<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ls.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/12
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
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<%
    String info= (String) request.getAttribute("info");
    if (info!=null){
        out.println("<h2>"+info+"</h2>");
    }
%>
<table border="1px solid #000000" cellspacing="0" style="text-align: center">
    <caption>商品列表</caption>
    <tr>
        <th>商品名</th>
        <th>商品类型</th>
        <th>商品价格</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="product" items="${sessionScope.products}">
        <tr>
            <td>${product.productName}</td>
            <td>${product.productType}</td>
            <td>${product.productPrice}</td>
            <td><a href="show_product_detail.view?oper=search&productId=${product.id}">查看详情</a></td>
            <td><a href="show_product_detail.view?oper=update&productId=${product.id}">更新商品</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
