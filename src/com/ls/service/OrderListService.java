package com.ls.service;


import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/18 16:26.
 * To Be or Not to Be
 */
public interface OrderListService {
    //添加订单，返回订单id
    Integer addOrderListBackId(Integer customerId, Integer addressId, BigDecimal totalMoney);
    //更改订单状态
    boolean updateOrderListStatus(String status,Integer orderListId);
    //删除某一个订单
    boolean deleteOrderList(Integer orderlistId);
}
