<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/14
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                contextPath + "/";
    %>
    <title>货架管理</title>
    <base href="<%=basePath%>">
    <%--<script>
        function onShelf(obj) {
            if (obj != null) {
                window.alert("该商品库存不足，无法上架")
                obj.href = "javascript:void(0)";
                var tds = obj.parentNode.parentNode.childNodes;
                var stockNumber = 0;
                var shelfStatus = null;
                for (var i = 1; i < tds.length; i += 2) {
                    if (tds[i].className.trim() == "stockNumber") {
                        console.log("111" + stockNumber);
                        stockNumber = tds[i].innerHTML;
                        console.log("222" + stockNumber);
                    }
                    if (tds[i].className.trim() == "shelfStatus") {
                        shelfStatus = tds[i].innerHTML;
                    }
                }
                console.log("333" + stockNumber);
                if (stockNumber==0) {
                    console.log("444" + stockNumber);
                    window.alert("该商品库存不足，无法上架");
                    obj.href = "javascript:void(0);"
                }
                if (shelfStatus.trim()=="已上架") {
                    window.alert("该商品已上架，无需重复操作");
                    obj.href = "javascript:void(0);";
                }
            }
        }
        function offShelf(obj) {
            if (obj != null) {
                var tds = obj.parentNode.parentNode.childNodes;
                var stockNumber = 0;
                var shelfStatus = null;
                //上下架出问题
                for (var i = 1; i < tds.length; i += 2) {
                    if (tds[i].className.trim() == "stockNumber") {
                        stockNumber = tds[i].innerHTML;
                    }
                    if (tds[i].className.trim() == "shelfStatus") {
                        shelfStatus = tds[i].innerHTML;
                    }
                }
                if (shelfStatus.trim() == "已下架") {
                    window.alert("商品已下架，无需重复操作");
                    obj.href = "javascript:void(0);"
                }

                if (shelfStatus.trim() == "未上架") {
                    window.alert("商品未上架，请选择上架操作");
                    obj.href = "javascript:void(0);"
                }
            }
        }
    </script>--%>
    <script>
        function onShelf(obj) {

            if (obj!=null){
                var tds= obj.parentNode.parentNode.childNodes;
                var  stockNumber=0;
                var shelfStatus=null;
                for(var i=1;i<tds.length;i+=2){
                    if (tds[i].className.trim()=="stockNumber"){
                        stockNumber= tds[i].innerHTML;
                    }
                    if (tds[i].className.trim()=="shelfStatus"){
                        shelfStatus= tds[i].innerHTML;
                    }
                }
                if (stockNumber==0||stockNumber.trim().length==0){
                    window.alert("商品库存不足，不能上架");
                    obj.href="javascript:void(0);"
                }
                if (shelfStatus.trim()=="已上架"){
                    window.alert("商品已上架，请勿重复操作");
                    obj.href="javascript:void(0);"
                }

            }
        }
        function offShelf(obj) {
            if (obj!=null){
                var tds= obj.parentNode.parentNode.childNodes;
                var  stockNumber=0;
                var shelfStatus=null;
                for(var i=1;i<tds.length;i+=2){
                    if (tds[i].className.trim()=="stockNumber"){
                        stockNumber= tds[i].innerHTML;
                    }
                    if (tds[i].className.trim()=="shelfStatus"){
                        shelfStatus= tds[i].innerHTML;
                    }
                }

                if (shelfStatus.trim()=="已下架"){
                    window.alert("商品已下架，请勿重复操作");
                    obj.href="javascript:void(0);"
                }
                if (shelfStatus.trim()=="未上架"){
                    window.alert("商品未上架，请选择上架操作");
                    obj.href="javascript:void(0);"
                }

            }
        }


    </script>
</head>
<a href="page/admin/adminIndex.jsp">首页</a><br />
<h2><c:out value="${requestScope.info}"></c:out></h2>
<table border="1px solid #000000" cellspacing="0" style="text-align: center">
    <caption>库存信息</caption>
    <tr>
        <th>商品名</th>
        <th>价格</th>
        <th>库存</th>
        <th>上下架时间</th>
        <th>操作人</th>
        <th>状态</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="shelfInfo" items="${requestScope.shelfInfos}">
        <tr>
            <c:set var="status"/>
            <td>${shelfInfo.productName}</td>
            <td>${shelfInfo.productPrice}</td>
            <td class="stockNumber">${shelfInfo.stockNumber==null?0:shelfInfo.stockNumber}</td>
            <td>${shelfInfo.shelfCreateTime==null?'暂无':shelfInfo.shelfCreateTime}</td>
            <td>${shelfInfo.adminName==null?'暂无':shelfInfo.adminName}</td>
            <td class="shelfStatus">${status=shelfInfo.shelfStatus==null?'未上架':shelfInfo.shelfStatus}</td>
            <td>
                <a href="on_off_shelf.do?oper=on&shelfStatus=${status}&productId=${shelfInfo.productId}&stockNumber=${shelfInfo.stockNumber}"
                   onclick="onShelf(this)">上架</a></td>
            <td>
                <a href="on_off_shelf.do?oper=off&shelfStatus=${status}&productId=${shelfInfo.productId}&stockNumber=${shelfInfo.stockNumber}"
                   onclick="offShelf(this)">下架</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
