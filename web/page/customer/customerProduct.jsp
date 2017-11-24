<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ls.entity.ProductInfo" %>
<%@ page import="com.ls.entity.ShelfProductInfos" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/17
  Time: 11:54
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
    <title>商品详情页</title>
    <base href="<%= basePath%>">
    <style>
        .float-left{
            float: left;
        }
        .wid3{
            width: 30%;
        }
        .wid7{
            width: 70%;
        }
    </style>
    <script src="js/jquery-min.js"></script>
    <script>
        function decrease(btn){
            //获取按钮的父亲td2
            var de = btn.parentNode;
            //获取td2的文本框
            var array=de.getElementsByTagName("input");
            //数量
            var text =array[4];
            //获取文本框的值-1写回文本框
            var amount = text.value;
            if (amount>1){
                amount--;
                text.value=amount;
            }
            var stockNumber=$("#stockNumber").text();
            if (amount<=stockNumber){
                $("#check").text("有货");
            }else {
                $("#check").text("库存不足");
            }
            console.log("数量"+amount);
            var unitPrice=$("#unit_price").text();
            console.log("单价"+unitPrice);
            var allPrice=$("#allPrice").text(unitPrice*amount);

            console.log("小计："+allPrice);
        }
        function increase(btn){
            //获取按钮的父亲td2
            var de = btn.parentNode;
            //获取td2的文本框
            var text = de.getElementsByTagName("input")[4];
            //获取文本框的值-1写回文本框
            var amount = text.value;
            amount++;
            console.log("数量"+amount);
            text.value=amount;
            var stockNumber=$("#stockNumber").text();
            if (amount<=stockNumber){
                $("#check").text("有货");
            }else {
                $("#check").text("库存不足");
            }
            console.log("数量"+amount);
            var unitPrice=$("#unit_price").text();
            console.log("单价"+unitPrice);
            var allPrice=$("#allPrice").text(unitPrice*amount);

            console.log("小计："+allPrice);
        }
        function checkNumber(btn) {
            var amount = btn.value;
            if (amount<0){
                btn.value=1;
                amount=1;
            }
            var stockNumber=$("#stockNumber").text();
            console.log("库存"+stockNumber);
            console.assert(amount<=stockNumber);
            if (amount<=stockNumber){
                $("#check").text("有货");
                console.log("12345677")
            }else {
                $("#check").text("库存不足");
                console.log("==12345677")
            }
            console.log("数量"+amount);
            var unitPrice=$("#unit_price").text();
            console.log("单价"+unitPrice);
            var allPrice=$("#allPrice").text(unitPrice*amount);

            console.log("小计："+allPrice);
        }
    </script>
</head>
<body>
<a href="page/customer/customerIndex.jsp">返回首页</a>
<%
    ShelfProductInfos shelfProductInfos= (ShelfProductInfos) session.getAttribute("productInfo");
%>
<div>
    <a href="shopcart_info.view">查看购物车</a>
</div>
<br />
<div>
    <div class="float-left wid3">
        <img src="<%= shelfProductInfos.getBigImage()%>">
        <%--小图<img src="<%= shelfProductInfos.getSmallImage()%>">--%>
    </div>
    <%--<div>
        <p>商品名<%= shelfProductInfos.getProductName()%></p>
        <p>价格<%= shelfProductInfos.getProductPrice()%></p>
        <p>库存<%= shelfProductInfos.getStockNumber()%></p>
        <p>类型<%= shelfProductInfos.getProductType()%></p>
        <p>说明<%= shelfProductInfos.getProductCaption()%></p>
    </div>--%>
    <div class="float-left wid3">
        <form action="add_shopcart.do" method="post">
            <input type="text" name="productId" value="<%= shelfProductInfos.getpId()%>" hidden="hidden">
            <input type="text" name="productName" value="<%= shelfProductInfos.getProductName()%>" hidden="hidden">
            <input type="text" name="productPrice" value="<%= shelfProductInfos.getProductPrice()%>" hidden="hidden">
            <p><%= shelfProductInfos.getProductName()%></p>
            价格：<span id="unit_price"><%= shelfProductInfos.getProductPrice()%></span><br />
            类型：<span><%= shelfProductInfos.getProductType()%></span><br />
            说明：<p><%= shelfProductInfos.getProductCaption()%></p><br />
            库存：<span id="stockNumber"><%= shelfProductInfos.getStockNumber()%></span><br />
            <input type="button" value="-" onclick="decrease(this)"/>
            <input id="count" type="text" name="productCartCount" value="1" min="1" readonly="readonly">   <%--onblur="checkNumber(this)" onmouseleave="checkNumber(this)"--%>
            <input type="button" value="+" onclick="increase(this)"/><span id="check"></span><br /><br />
            小计：<span id="allPrice"><%= shelfProductInfos.getProductPrice()%></span>￥<br /><br />
            <input type="submit" value="加入购物车"><br />
        </form>
    </div>
</div>
</body>
</html>
