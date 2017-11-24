package com.ls.dao.impl;

import com.ls.dao.OrderItemInfoDao;
import com.ls.entity.OrderItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/25 16:32.
 * To Be or Not to Be
 */
public class OrderItemInfoDaoImpl extends BaseDao implements OrderItemInfoDao{

    @Override
    public List<OrderItemInfo> findOrderItemInfoByOrderListId(Integer orderListId) {
        String sql="select order_list_id,order_item.product_id,product_count,shelf_status,stock_number from order_item left join shelf ON order_item.product_id=shelf.product_id LEFT JOIN stock ON stock.product_id=order_item.product_id where order_list_id=?";
        List<Object> params=new ArrayList<>();
        params.add(orderListId);
        List<OrderItemInfo> query = query(sql, params, OrderItemInfo.class);
        return query;
    }
}
