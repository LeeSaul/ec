package com.ls.dao;

import com.ls.entity.OrderItemInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/25 16:32.
 * To Be or Not to Be
 */
public interface OrderItemInfoDao {
    //����ĳ������id�鿴��Ϣ
    List<OrderItemInfo> findOrderItemInfoByOrderListId(Integer orderListId);
}
