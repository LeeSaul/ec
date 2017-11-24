<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ls.entity.OrderListInfo" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/21
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                contextPath + "/";
    %>
    <title>顾客订单页</title>
    <base href="<%= basePath%>">
    <style>
        td {
            width: 100px;
        }
    </style>
    <script>
        function ensure() {
            var msg = "您真的确定要收货吗？";
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
<a href="page/customer/customerIndex.jsp">首页</a><br />
<a href="customer_orders.view">全部订单</a>
<a href="customer_orders_status.view?status=NOT_PAY">待付款</a>
<a href="customer_orders_status.view?status=NOT_SEND">待发货</a>
<a href="customer_orders_status.view?status=NOT_CONFIRMED">待确认</a>
<a href="customer_orders_status.view?status=CONFIRMED">已完成</a>
<c:choose>
<c:when test="${requestScope.orders!=null}">
    <%
        List<OrderListInfo> orders = (List<OrderListInfo>) request.getAttribute("orders");
        Set<Integer> set = new HashSet();
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
            int temp = 0;
            for (int j = 0; j < orders.size(); j++) {
                String status = null;
                if (orders.get(j).getOrderListId() == listId) {
                    if (orders.get(j).getOrderStatus().toUpperCase().equals("NOT_PAY")) {
                        status = "未付款";
                    } else if (orders.get(j).getOrderStatus().toUpperCase().equals("NOT_SEND")) {
                        status = "未发货";
                    } else if (orders.get(j).getOrderStatus().toUpperCase().equals("NOT_CONFIRMED")) {
                        status = "待确认";
                    } else if (orders.get(j).getOrderStatus().toUpperCase().equals("CONFIRMED")) {
                        status = "已完成";
                    } else {
                        status = "未知";
                    }
                    temp = j;
        %>
        <tr>
            <td><img src="<%=orders.get(j).getSmallImage()%>"/></td>
            <td><%=orders.get(j).getProductName()%>
            </td>
            <td><%=orders.get(j).getProductPrice()%>
            </td>
            <td><%=orders.get(j).getProductCount()%>
            </td>
            <td><%=status%>
            </td>
            <td><a href="show_order_detail.view?orderItemId=<%=orders.get(j).getOrderItemId()%>">查看详情</a></td>
            <%
                }
                if (j == orders.size() - 1) {
            %>
                <%--<td style="text-align: center" rowspan="<%=k%>"><%=orders.get(temp).getTotalMoney()%></td>--%>
        </tr>
        <h4><%=orders.get(temp).getOrderCreateTime()%>&nbsp;订单号:<%=orders.get(temp).getOrderListId()%>
            &nbsp;总金额:<%=orders.get(temp).getTotalMoney()%>
        </h4>
        <%
            System.out.println(orders.get(temp).getOrderStatus());
            if (orders.get(temp).getOrderStatus().toUpperCase().equals("NOT_PAY")) {
        %>
        <a href="update_status.do?orderListId=<%=orders.get(temp).getOrderListId()%>&status=<%=orders.get(temp).getOrderStatus()%>&oper=cancle" onclick="return cancle()">取消订单</a>&nbsp;
        <a href="update_status.do?orderListId=<%=orders.get(temp).getOrderListId()%>&status=<%=orders.get(temp).getOrderStatus()%>&oper=pay&totalMoney=<%=orders.get(temp).getTotalMoney()%>">去付款</a>
        <%
        } else if (orders.get(temp).getOrderStatus().toUpperCase().equals("NOT_CONFIRMED")) {
        %>
        <a href="update_status.do?orderListId=<%=orders.get(temp).getOrderListId()%>&status=<%=orders.get(temp).getOrderStatus()%>" onclick="return ensure()">确认收货</a>
        <%
                    }
                }
            }
        %>
    </table>
    <br/>
    <%
        }
    %>
</c:when>
<c:otherwise>
    <h2>${requestScope.info}</h2>
</c:otherwise>
</c:choose>
</body>
</html>
