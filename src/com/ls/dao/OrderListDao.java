package com.ls.dao;

import com.ls.entity.OrderList;

/**
 * Created by LS on 2017/9/18 15:32.
 * To Be or Not to Be
 */
public interface OrderListDao {
    //��Ӷ��������ض���id
    Integer addOrderListBackId(OrderList orderList);
    //���Ķ���״̬
    boolean updateOrderListStatus(String status,Integer orderListId);
    //ɾ��ĳһ������
    boolean deleteOrderList(Integer orderlistId);
}
