package com.ls.service;


import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/18 16:26.
 * To Be or Not to Be
 */
public interface OrderListService {
    //��Ӷ��������ض���id
    Integer addOrderListBackId(Integer customerId, Integer addressId, BigDecimal totalMoney);
    //���Ķ���״̬
    boolean updateOrderListStatus(String status,Integer orderListId);
    //ɾ��ĳһ������
    boolean deleteOrderList(Integer orderlistId);
}
