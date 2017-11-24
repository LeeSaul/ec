<%@ page import="com.ls.entity.OrderListInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/20
  Time: 10:40
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
    <title>订单页</title>
    <base href="<%= basePath%>">
    <style>
        td{
            width: 100px;
        }
    </style>
    <script>
        function shipped() {
            var msg = "您真的确定要发货吗？";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
        function cancle() {
            var msg = "您真的确定要取消该订单吗？";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<a href="show_all_orders.view">所有订单</a>
<a href="show_orders_status.view?status=NOT_PAY">待付款</a>
<a href="show_orders_status.view?status=NOT_SEND">待发货</a>
<a href="show_orders_status.view?status=NOT_CONFIRMED">待确认</a>
<a href="show_orders_status.view?status=CONFIRMED">已完成</a>
<%--<h1>${requestScope.info}</h1>--%>
<%--
<table style="text-align: center" border="1px solid #000000" cellspacing="0">
    <tr>
        <th></th>
        <th>商品名</th>
        <th>商品价格</th>
        <th>数量</th>
        <th>订单总金额</th>
        <th>商品状态</th>
        <th>订单创建时间</th>
        <th>订单ID</th>
    </tr>
    <c:forEach var="order" items="${requestScope.orders}">
        <tr>
            <td class="td1"><img src="${order.smallImage}" /></td>
            <td>${order.productName}</td>
            <td>${order.productPrice}</td>
            <td>${order.productCount}</td>
            <td>${order.totalMoney}</td>
            <td>${order.itemOrderStatus=='NOT_SHIPPED'?'未发货':'已发货'}</td>
            <td >${order.orderCreateTime}</td>
            <td>${order.orderListId}</td>
            <td><a href="show_order_detail.view?orderItemId=${order.orderItemId}">查看详情</a></td>
            <td><a href="">发货</a></td>
        </tr>
    </c:forEach>

--%>
<c:choose>
    <c:when test="${requestScope.orders!=null}">
        <%
            List<OrderListInfo> orders = (List<OrderListInfo>) request.getAttribute("orders");
            Set<Integer> set=new HashSet();
            for (int i = 0; i < orders.size(); i++) {
                set.add(orders.get(i).getOrderListId());
            }
            for (Integer listId : set) {
        %>
        <table style="text-align: center" border="1px solid #000000" cellspacing="0">
            <tr>
                <td></td>
                <td>商品名</td>
                <td>单价</td>
                <td>数量</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            <%
                int temp=0;
                for (int j = 0; j < orders.size(); j++) {
                    String status=null;
                    if (orders.get(j).getOrderListId()==listId){
                        if (orders.get(j).getOrderStatus().toUpperCase().equals("NOT_PAY")){
                            status="未付款";
                        }else if(orders.get(j).getOrderStatus().toUpperCase().equals("NOT_SEND")){
                            status="未发货";
                        }else if (orders.get(j).getOrderStatus().toUpperCase().equals("NOT_CONFIRMED")){
                            status="待确认";
                        }else if (orders.get(j).getOrderStatus().toUpperCase().equals("CONFIRMED")){
                            status="已完成";
                        }else {
                            status="未知";
                        }
                        temp=j;
            %>
            <tr>
                <td><img src="<%=orders.get(j).getSmallImage()%>" /></td>
                <td><%=orders.get(j).getProductName()%></td>
                <td><%=orders.get(j).getProductPrice()%></td>
                <td><%=orders.get(j).getProductCount()%></td>
                <td><%=status%></td>
                <td><a href="show_order_detail.view?orderItemId=<%=orders.get(j).getOrderItemId()%>">查看详情</a></td>
                <%}
                    if (j==orders.size()-1){
                %>
                    <%--<td style="text-align: center" rowspan="<%=k%>"><%=orders.get(temp).getTotalMoney()%></td>--%>
            </tr>
            <h4><%=orders.get(temp).getOrderCreateTime()%>&nbsp;订单号:<%=orders.get(temp).getOrderListId()%>
                &nbsp;总金额:<%=orders.get(temp).getTotalMoney()%></h4>
            <%
                System.out.println(orders.get(temp).getOrderStatus());
                if (orders.get(temp).getOrderStatus().toUpperCase().equals("NOT_PAY")){
            %>
            <a href="update_status.do?orderListId=<%=orders.get(temp).getOrderListId()%>&status=<%=orders.get(temp).getOrderStatus()%>&oper=cancle" onclick="return cancle()">取消订单</a>
            <%
            }else if(orders.get(temp).getOrderStatus().toUpperCase().equals("NOT_SEND")){
            %>
            <a href="update_status.do?orderListId=<%=orders.get(temp).getOrderListId()%>&status=<%=orders.get(temp).getOrderStatus()%>" onclick="return shipped()">发货</a>
            <%
                        }
                    }
                }
            %>
        </table>
        <br />
        <%
            }
        %>
    </c:when>
    <c:otherwise>
        <h2>${requestScope.info}</h2>
    </c:otherwise>
</c:choose>
       <%--<c:forEach var="order" items="${requestScope.orders}">
           <c:set var="orderId" value="${order.orderListId}">
                <table style="text-align: center" border="1px solid #000000" cellspacing="0">
                       <c:forEach var="orderList" items="${requestScope.orders}">
                           <c:if test="${orderId}==${orderList.orderListId}">
                               <tr>
                               <td class="td1"><img src="${orderList.smallImage}" /></td>
                               <td>${orderList.productName}</td>
                               <td>${orderList.productPrice}</td>
                               <td>${orderList.productCount}</td>
                               <td>${orderList.totalMoney}</td>
                               </tr>
                           </c:if>
                       </c:forEach>
                </table>
           </c:set>
       </c:forEach>--%>
</body>
</html>
