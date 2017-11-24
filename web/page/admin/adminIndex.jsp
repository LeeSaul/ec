<%@ page import="com.ls.entity.Admin" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/11
  Time: 19:41
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
    <title>管理员主页</title>
    <base href="<%= basePath%>">
</head>
<body>
<%
    Admin admin = (Admin)session.getAttribute("admin");
%>
<p>管理员名：<%=admin.getAdminName()%></p>
<p>金额：<%=admin.getAdminMoney()%></p>
<p>管理员状态：<%=admin.getAdminState()%></p>
<p>上次登录时间：<%=admin.getAdminLastTime()%></p>
<hr/>
<a href="page/product/productManger.jsp">商品管理</a>
<a href="page/stock/stockManger.jsp">库存管理</a>
<a href="page/shelf/shelfManger.jsp">货架管理</a>
<a href="page/admin/adminOrderlistManger.jsp">订单管理</a>
<a href="exit_admin.do">退出</a>
</body>
</html>
