<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/15
  Time: 8:30
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
    <title>货架管理</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">首页</a><br />
<a href="show_shelf.view">查看货架信息</a>
</body>
</html>
