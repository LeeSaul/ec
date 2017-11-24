<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 18:20
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
    <title>显示仓库信息</title>
    <base href="<%=basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">返回首页</a>
<h2><c:out value="${requestScope.info}"></c:out></h2>
<table border="1px solid #000000" cellspacing="0" style="text-align: center">
    <caption>库存信息</caption>
    <tr>
        <th>商品名</th>
        <th>类型</th>
        <th>价格</th>
        <th>库存</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="stockInfo" items="${requestScope.stockInfos}">
    <tr>
        <td>${stockInfo.productName}</td>
        <td>${stockInfo.productType}</td>
        <td>${stockInfo.productPrice}</td>
        <td>${stockInfo.stockNumber==null?0:stockInfo.stockNumber}</td>
        <td>${stockInfo.stockUpdateTime==null?'暂无':stockInfo.stockUpdateTime}</td>
        <td><a href="add_stock.view?productId=${stockInfo.pId}">增加库存</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
