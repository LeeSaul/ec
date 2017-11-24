<%@ page import="com.ls.entity.ProductInfo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 17:40
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
<%
    ProductInfo productInfo= (ProductInfo) request.getAttribute("productInfo");

%>



<form name="form1" action="update_product_detail.do?pId=<%= productInfo.getProduct().getId()%>" method="post" enctype="multipart/form-data">
    商品名：<input type="text" name="productName" value="<%= productInfo.getProduct().getProductName()%>"><br/>
    价格：<input type="text" name="productPrice" value="<%= productInfo.getProduct().getProductPrice()%>"><br/>
    类型：<input type="text" name="productType" value="<%= productInfo.getProduct().getProductType()%>"><br/>
    <img src="<%= productInfo.getProductDetail().getSmallImage()%>"><br/>
    重新选择小图：<input type="file" name="product_small_Image"><br/>
    <img src="<%= productInfo.getProductDetail().getBigImage()%>"><br/>
    重新选择大图：<input type="file" name="product_big_Image"><br/>
    商品说明：<textarea rows="5" cols="40" name="productCaption"><%= productInfo.getProductDetail().getProductCaption()%></textarea>
    <input type="submit" value="更新商品">
</form>
<a href="page/product/showProducts.jsp">取消更新</a>
</body>
</html>
