<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/13
  Time: 14:58
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
    <title>用户主页</title>
    <base href="<%= basePath%>">
    <script>
        var xmlhttp;
        var mydata;
        function  listProduct(number,page){
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            if (xmlhttp!=null){
                xmlhttp.open("GET","shelf_product.view?number="+number+"&page="+page,true);
                xmlhttp.send();
                xmlhttp.onreadystatechange=result;
            }
        }
        function result() {
            if (xmlhttp.readyState==4 &&xmlhttp.status==200){
                myData=xmlhttp.responseText.trim();
                show(myData)
            }
        }
        function show(myData) {
            myData=JSON.parse(myData);
            console.log(myData);
            var  div1=   document.getElementById("div1");
            var  string=null;
            string="<table border='1px solid #000000' cellspacing='0' style='text-align: center'>";
//            string=string+"<caption>浏览商品</caption>";
            for(var i=0;i<myData.length;i++){
                if (i%5==0){
                    string=string+"<tr>";
                }
                string=string+"<td>";
                string=string+"<ul>" +
                    "<li>"+"<a href='customer_productDetail.view?productId="+myData[i].pId+"'>"+"<img src='"+myData[i].smallImage+"'/></a></li>" +
//                    "<li>"+"<img src='"+myData[i].bigImage+"'/></li>" +
                    "<li>"+myData[i].productName+"</li>" +
//                    "<li>"+myData[i].productType+"</li>" +
                    "<li>￥"+myData[i].productPrice+"</li>" +
                    "</ul>";
                string=string+"</td>";
                if (i%5==4){
                    string=string+"</tr>";
                }
            }
            string=string+"</tr>";
            string=string+"</table>";
            div1.innerHTML=string;
        }
        window.onload=listProduct(10,1);
    </script>
    <style>
        #div1{
            margin-left: 9%;
        }
        ul,li{
            list-style: none;
        }
        ul{
            margin-left: -40px;
        }
        #bottomPage{
            float: right;
        }
        .p-num{
            float: left;
            margin-right: 159px;
            margin-top: 20px;
            font-size: x-large;
        }
        .pageNum{
            background-color: #eae0e0;
            color: #7a5b5b;
            display: block;
            width: 31px;
            height: 31px;
            float: left;
            margin: 6px;
            text-align: center;
            text-decoration:none;
        }
    </style>
</head>
<body>
<div>
    <a href="page/customer/recharge.jsp">充值</a>
    <a href="page/customer/customerOrderlistManger.jsp">查看订单</a>
    <h3>${requestScope.info}</h3>
    <%--${requestScope.productName}
    ${requestScope.productPrice}
    ${requestScope.productCartCount}
    <br />--%>
    <a href="shopcart_info.view">查看购物车</a>
    <h2>用户名：${sessionScope.customer.customerName}</h2>
    <%--<h2>手机号：${sessionScope.customer.customerPhone}</h2>--%>
    <%--<h2>邮箱：${sessionScope.customer.customerEmail}</h2>--%>
    <h2>账户余额：${sessionScope.customer.customerMoney}</h2>
    <%--<h2>开户时间：${sessionScope.customer.customerCreateTime}</h2>--%>
    <%--<h2>登录时间：${sessionScope.customer.loginTime}</h2>--%>
    <%--<h2>状态：${sessionScope.customer.customerStatus}</h2>--%>
    <a href="exit_customer.do">退出</a>
</div>
<div id="div1">
</div>
<div id="bottomPage">
    <span class="p-num">
        <a class="pageNum" href="javascript:void(0)" onclick="listProduct(10,1)">1</a>
        <a class="pageNum" href="javascript:void(0)" onclick="listProduct(10,2)">2</a>
        <a class="pageNum" href="javascript:void(0)" onclick="listProduct(10,3)">3</a>
        <a class="pageNum" href="javascript:void(0)" onclick="listProduct(10,4)">4</a>
    </span>
</div >
</body>
</html>
