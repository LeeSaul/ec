package com.ls.service;

/**
 * Created by LS on 2017/9/18 19:06.
 * To Be or Not to Be
 */
public interface OrderItemService {
    //添加订单子项
    Integer addOrderItem(Integer orderListId,Integer productId,Integer productCount);
    //更改订单状态为发货
    boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId);
    //删除某一个订单
    boolean deleteOrderItem(Integer orderlistId);
}
