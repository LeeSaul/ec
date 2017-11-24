package com.ls.service;

import com.ls.entity.OrderItemInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/25 16:47.
 * To Be or Not to Be
 */
public interface OrderItemInfoService {
    //根据某个订单id查看信息
    List<OrderItemInfo> findOrderItemInfoByOrderListId(Integer orderListId);
}
