package com.ls.dao;

import com.ls.entity.OrderListInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/20 7:47.
 * To Be or Not to Be
 */
public interface OrderListInfoDao {
    //��ʾĳ���˿͵����ж���
    List<OrderListInfo> ListOrders(Integer customerId);
    //��ʾ�ù˿�ĳ������������
    OrderListInfo OrderDetails(Integer orderItemId);
    //��ʾ���е��Ѹ����
    List<OrderListInfo> ListOrdersByStatus(String status);
    //����Ա�鿴Ŀǰ���ж���
    List<OrderListInfo> ListOrders();
    //��ʾĳ���˿�ĳ״̬�Ķ���
    List<OrderListInfo> ListCustomerOrdersByStatus(String status,Integer customerId);
}
