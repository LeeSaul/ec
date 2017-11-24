package com.ls.service.impl;

import com.ls.dao.OrderItemDao;
import com.ls.dao.impl.OrderItemDaoImpl;
import com.ls.entity.OrderItem;
import com.ls.service.OrderItemService;

/**
 * Created by LS on 2017/9/18 19:06.
 * To Be or Not to Be
 */
public class OrderItemServiceImpl implements OrderItemService{
    private OrderItemDao orderItemDao;

    public OrderItemServiceImpl() {
        orderItemDao=new OrderItemDaoImpl();
    }

    @Override
    public Integer addOrderItem(Integer orderListId,Integer productId,Integer productCount) {
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderListId(orderListId);
        orderItem.setProductId(productId);
        orderItem.setProductCount(productCount);
        orderItem.setItemOrderStatus(OrderItem.ITEM_NOT_SHIPPED);//Î´·¢»õ
        return orderItemDao.addOrderItem(orderItem);
    }

    @Override
    public boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId) {
        return orderItemDao.udpdateOrderItemStatus(orderStatus,orderListId);
    }

    @Override
    public boolean deleteOrderItem(Integer orderlistId) {
        return orderItemDao.deleteOrderItem(orderlistId);
    }
}
