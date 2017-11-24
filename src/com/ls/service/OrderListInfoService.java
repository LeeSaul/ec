package com.ls.service;

import com.ls.entity.OrderListInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/20 7:46.
 * To Be or Not to Be
 */
public interface OrderListInfoService {
    //显示某个顾客的所有订单
    List<OrderListInfo> ListOrders(Integer customerId);
    //显示该顾客某个订单的详情
    OrderListInfo OrderDetails(Integer orderItemId);
    //显示某个状态的订单
    List<OrderListInfo> ListOrdersByStatus(String status);
    //管理员查看目前所有订单
    List<OrderListInfo> ListOrders();
    //显示某个顾客某状态的订单
    List<OrderListInfo> ListCustomerOrdersByStatus(String status,Integer customerId);
}
