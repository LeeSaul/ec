package com.ls.service.impl;

import com.ls.dao.OrderListInfoDao;
import com.ls.dao.impl.OrderListInfoDaoImpl;
import com.ls.entity.OrderListInfo;
import com.ls.service.OrderListInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/20 8:12.
 * To Be or Not to Be
 */
public class OrderListInfoServiceImpl implements OrderListInfoService{
    private OrderListInfoDao orderListInfoDao;

    public OrderListInfoServiceImpl() {
        orderListInfoDao=new OrderListInfoDaoImpl();
    }

    @Override
    public List<OrderListInfo> ListOrders(Integer customerId) {
        return orderListInfoDao.ListOrders(customerId);
    }

    @Override
    public OrderListInfo OrderDetails(Integer orderItemId) {
        return orderListInfoDao.OrderDetails(orderItemId);
    }

    @Override
    public List<OrderListInfo> ListOrdersByStatus(String status) {
        return orderListInfoDao.ListOrdersByStatus(status);
    }

    @Override
    public List<OrderListInfo> ListOrders() {
        return orderListInfoDao.ListOrders();
    }

    @Override
    public List<OrderListInfo> ListCustomerOrdersByStatus(String status, Integer customerId) {
        return orderListInfoDao.ListCustomerOrdersByStatus(status,customerId);
    }
}
