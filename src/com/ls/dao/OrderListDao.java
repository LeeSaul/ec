package com.ls.dao;

import com.ls.entity.OrderList;

/**
 * Created by LS on 2017/9/18 15:32.
 * To Be or Not to Be
 */
public interface OrderListDao {
    //添加订单，返回订单id
    Integer addOrderListBackId(OrderList orderList);
    //更改订单状态
    boolean updateOrderListStatus(String status,Integer orderListId);
    //删除某一个订单
    boolean deleteOrderList(Integer orderlistId);
}
