<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/12
  Time: 18:27
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
    <title>增加商品页面</title>
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
<form name="form1" action="add_product.do" method="post" enctype="multipart/form-data">
    商品名：<input type="text" name="productName"><br/>
    价格：<input type="text" name="productPrice"><br/>
    类型：<input type="text" name="productType"><br/>
    小图：<input type="file" name="product_small_Image"><br/>
    大图：<input type="file" name="product_big_Image"><br/>
    商品说明：<textarea rows="5" cols="40" name="productCaption"></textarea>
    <input type="submit" value="增加商品">
</form>
</body>
</html>
