package com.ls.service;

/**
 * Created by LS on 2017/9/18 19:06.
 * To Be or Not to Be
 */
public interface OrderItemService {
    //��Ӷ�������
    Integer addOrderItem(Integer orderListId,Integer productId,Integer productCount);
    //���Ķ���״̬Ϊ����
    boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId);
    //ɾ��ĳһ������
    boolean deleteOrderItem(Integer orderlistId);
}
