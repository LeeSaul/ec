<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/12
  Time: 18:24
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
    <title>商品管理</title>
    <base href="<%= basePath%>">
</head>
<body>
<a href="page/admin/adminIndex.jsp">首页</a><br />
<%
    String info= (String) request.getAttribute("info");
    if (info!=null){
        out.println("<h2>"+info+"</h2>");
    }
%>
<a href="page/admin/adminIndex.jsp">返回首页</a>
<a href="page/product/addProduct.jsp">增加商品</a>
<a href="show_product.view">查看商品</a>
</body>
</html>
