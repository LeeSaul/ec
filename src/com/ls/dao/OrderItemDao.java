package com.ls.dao;

import com.ls.entity.OrderItem;

/**
 * Created by LS on 2017/9/18 18:56.
 * To Be or Not to Be
 */
public interface OrderItemDao {
    //��Ӷ�������
    Integer addOrderItem(OrderItem orderItem);
    //���Ķ���״̬
    boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId);
    //ɾ��ĳһ������
    boolean deleteOrderItem(Integer orderlistId);
}
