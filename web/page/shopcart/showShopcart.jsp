<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/17
  Time: 13:23
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
    <title>购物车</title>
    <base href="<%= basePath%>">
    <style>
        .td1{
            width: 90px;
        }
        .img1{
            width: 100%;
            height:100%;
        }
    </style>
    <script src="js/jquery-min.js"></script>
    <script>
        function decrease(btn){
            console.log("btn"+btn);
            //获取按钮的父亲
            var td2 = btn.parentNode;
            console.log("td2"+td2);
            //获取td2内的文本框
            var text = td2.getElementsByTagName("input")[0];
            console.log("text.value"+text.value);
            //获取文本框内值-1后写回文本框
            var amount = text.value;
            if (amount<=1){
                return false;
            }
            /*if (amount>1){
                text.value = --amount;
            }
            var tr=td2.parentNode;
            console.log("tr"+tr);
            var unit_price=tr.getElementsByTagName("td")[2].innerHTML;
            var subTotal=tr.getElementsByTagName("td")[4].innerHTML;
            console.log("unit_price"+unit_price);
            console.log("subTotal"+subTotal);
            var sum=unit_price*amount;
            sum=parseFloat(sum.toFixed(2));
            console.log("=="+sum);
            tr.getElementsByTagName("td")[4].innerHTML=sum;
            console.log("小计"+tr.getElementsByTagName("td")[4].innerHTML);*/
        }
        function increase(btn){
            //获取按钮的父亲td2
            var td2 = btn.parentNode;
            console.log("td2"+td2);
            //获取td2的文本框
            var text = td2.getElementsByTagName("input")[0];
            console.log("text"+text);
            //获取文本框的值-1写回文本框
            var amount = text.value;
            console.log("数量"+amount);
            text.value = ++amount;
            var tr=td2.parentNode;
            console.log("tr"+tr);
            var unit_price=tr.getElementsByTagName("td")[2].innerHTML;
            var subTotal=tr.getElementsByTagName("td")[4].innerHTML;
            console.log("unit_price"+unit_price);
            console.log("subTotal"+subTotal);
            var sum=unit_price*amount;
            sum=parseFloat(sum.toFixed(2));
            console.log("=="+sum);
            tr.getElementsByTagName("td")[4].innerHTML=sum;
            console.log("小计"+tr.getElementsByTagName("td")[4].innerHTML);
        }

        function check() {
            var stockInfo=$(".stockInfo").text();
            console.log(stockInfo);
            for (var i = 0; i < stockInfo.length; i++) {
                var obj = stockInfo[i];
                if(obj.indexOf("无")>=0){
                    alert("存在商品无货，没法结算");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<a href="page/customer/customerIndex.jsp">首页</a>
${requestScope.info}<br />
<c:choose>
    <c:when test="${sessionScope.shopcartInfos!=null}">
        <a href="delete_shopcart.do">清空购物车</a>
        <table style="text-align: center">
            <th>
                <td>商品</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
                <td>操作</td>
            </th>
            <c:forEach var="shopcartInfos" items="${sessionScope.shopcartInfos}">
                <c:set var="temp" value="0" />
                <tr>
                    <td class="td1"><img src="${shopcartInfos.smallImage}" class="img1" /></td>
                    <td class="productName">${shopcartInfos.productName}</td>
                    <td>${shopcartInfos.productPrice}</td>
                    <td>
                        <a href="update_shopcart.do?shopcartId=${shopcartInfos.shopcartId}&oper=decrease&count=${shopcartInfos.productCartCount}" onclick="return decrease(this)">-</a>
                        <input  type="text" name="productCartCount" value="${shopcartInfos.productCartCount}" min="1" readonly="readonly">
                        <a href="update_shopcart.do?shopcartId=${shopcartInfos.shopcartId}&oper=add&count=${shopcartInfos.productCartCount}">+</a>
                        <span class="stockInfo">${shopcartInfos.productCartCount<=shopcartInfos.stockNumber?'有货':'无货'}</span>
                    </td>
                    <td>${temp=shopcartInfos.productPrice*shopcartInfos.productCartCount}</td>
                    <td><a href="delete_shopcart.do?shopcartId=${shopcartInfos.shopcartId}">删除</a></td>
                </tr>
                <c:set var="sum" value="${temp+sum}" />
            </c:forEach>
        </table>
        <span id="sum">总计：${sum}</span>
        <a href="order_list.view?totalMoney=${sum}" onclick="return check()">去结算</a>
    </c:when>
    <c:otherwise>
        <a href="page/customer/customerIndex.jsp">去购物</a>
    </c:otherwise>
</c:choose>
</body>
</html>
