<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 18:16
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
    <title>仓库管理</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">返回首页</a>
<a href="show_stockInfo.view">查看仓库</a>
<a href="show_innerStock.view">查看入库记录</a>
<a href="show_outStock.view">查看出库记录</a>
</body>
</html>
