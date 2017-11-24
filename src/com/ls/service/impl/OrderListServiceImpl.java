package com.ls.service.impl;

import com.ls.dao.OrderListDao;
import com.ls.dao.impl.OrderListDaoImpl;
import com.ls.entity.OrderList;
import com.ls.service.OrderListService;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/18 16:27.
 * To Be or Not to Be
 */
public class OrderListServiceImpl implements OrderListService{
    private OrderListDao orderListDao;

    public OrderListServiceImpl() {
        orderListDao=new OrderListDaoImpl();
    }

    @Override
    public Integer addOrderListBackId(Integer customerId, Integer addressId, BigDecimal totalMoney) {
        OrderList orderList=new OrderList();
        orderList.setCustomerId(customerId);
        orderList.setAddressId(addressId);
        orderList.setTotalMoney(totalMoney);
        return orderListDao.addOrderListBackId(orderList);
    }

    @Override
    public boolean updateOrderListStatus(String status,Integer orderListId) {
        return orderListDao.updateOrderListStatus(status,orderListId);
    }

    @Override
    public boolean deleteOrderList(Integer orderlistId) {
        return orderListDao.deleteOrderList(orderlistId);
    }
}
