package com.ls.service.impl;

import com.ls.dao.OrderItemInfoDao;
import com.ls.dao.impl.OrderItemInfoDaoImpl;
import com.ls.entity.OrderItemInfo;
import com.ls.service.OrderItemInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/25 16:47.
 * To Be or Not to Be
 */
public class OrderItemInfoServiceImpl implements OrderItemInfoService {
    private OrderItemInfoDao orderItemInfoDao;

    public OrderItemInfoServiceImpl() {
        orderItemInfoDao=new OrderItemInfoDaoImpl();
    }

    @Override
    public List<OrderItemInfo> findOrderItemInfoByOrderListId(Integer orderListId) {
        return orderItemInfoDao.findOrderItemInfoByOrderListId(orderListId);
    }
}
