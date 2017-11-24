<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/14
  Time: 7:51
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
    <title>入库记录</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">返回首页</a>
<h2>${requestScope.info}</h2>
<table border="1px solid #000000" cellspacing="0">
    <caption>入库记录</caption>
    <tr>
        <th>商品名</th>
        <th>入库单价</th>
        <th>入库数量</th>
        <th>入库时间</th>
        <th>总价</th>
        <th>操作员</th>
    </tr>
    <c:forEach var="innerStock" items="${requestScope.innerStocks}">
        <c:set var="temp" value="0" />
        <tr>
        <td>${innerStock.productName}</td>
        <td>${innerStock.innerUnitPrice}</td>
        <td>${innerStock.innerStockNumber}</td>
        <td>${innerStock.innerTime}</td>
        <td>${temp=innerStock.innerUnitPrice*innerStock.innerStockNumber}</td>
        <td>${innerStock.adminName}</td>
        </tr>
        <c:set var="sum" value="${temp+sum}" />
    </c:forEach>
</table>
<h2>合计：${sum}</h2>
</body>
</html>
