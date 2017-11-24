package com.ls.dao;

import com.ls.entity.OrderItem;

/**
 * Created by LS on 2017/9/18 18:56.
 * To Be or Not to Be
 */
public interface OrderItemDao {
    //添加订单子项
    Integer addOrderItem(OrderItem orderItem);
    //更改订单状态
    boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId);
    //删除某一个订单
    boolean deleteOrderItem(Integer orderlistId);
}
