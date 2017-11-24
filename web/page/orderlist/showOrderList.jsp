<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/18
  Time: 16:46
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
    <title>订单结算页</title>
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
    <script>
        function isChecked(obj){
            if(obj.checked==true){
                var va=obj.value;
//                alert("你选中的是" + va);
                document.form1.addressId.value=va;
                console.log(va);
            }
        }
        function checkedList() {
            if (document.form1.addressId.value.length==0){
                document.getElementById("warning").innerText="地址为空";
                console.log("地址为空");
                return false;
            }
            if (document.form1.totalMoney.value.length==0){
                document.getElementById("warning").innerText="订单为空";
                console.log("订单为空");
                return false;
            }
        }
        window.onload = function(){
            var va;
            var radio = document.getElementsByName("address");
            va=radio[0].value;
            console.log(va);
            document.form1.addressId.value=va;
            radio[0].checked = true;
        }
    </script>
</head>
<body>
<a href="page/customer/customerIndex.jsp">首页</a>
<span>${requestScope.info}</span><br />
<a href="page/orderlist/addAddress.jsp">增加收货地址</a>
<table style="text-align: center">
    <c:forEach var="address" items="${sessionScope.addresses}">
        <tr>
            <td><input type="radio" name="address" value="${address.id}" onclick="isChecked(this)"></td>
            <td>${address.province}</td>
            <td>${address.city}</td>
            <td>${address.county}</td>
            <td>${address.road}</td>
            <td>${address.addressPhone}</td>
            <td>${address.addressReceiver}</td>
            <td>${address.addressStatus=="DEFAULT"?"默认地址":"其他地址"}</td>
        </tr>
    </c:forEach>
</table>

<table style="text-align: center">
    <c:forEach var="shopcartInfos" items="${sessionScope.shopcartInfos}">
        <c:set var="temp" value="0" />
        <tr>
            <td class="td1"><img src="${shopcartInfos.smallImage}" class="img1" /></td>
            <td>${shopcartInfos.productName}</td>
            <td>${shopcartInfos.productPrice}</td>
            <td>${shopcartInfos.productCartCount}</td>
            <td>${temp=shopcartInfos.productPrice*shopcartInfos.productCartCount}</td>
        </tr>
        <c:set var="sum" value="${temp+sum}" />
    </c:forEach>
</table>
<span>应付总额：${sum}</span>
<form action="add.orderList.do" name="form1" onclick="return checkedList()">
    <input type="text" name="addressId" hidden="hidden">
    <input type="text" name="totalMoney" value="${sum}" hidden="hidden">
    <input type="submit" value="提交订单">
    <span id="warning"></span>
</form>
</body>
</html>
