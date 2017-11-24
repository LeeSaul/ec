package com.ls.dao.impl;

import com.ls.dao.OrderItemDao;
import com.ls.entity.OrderItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/18 18:56.
 * To Be or Not to Be
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{
    @Override
    public Integer addOrderItem(OrderItem orderItem) {
        String sql="insert into order_item(order_list_id,product_id,product_count,item_create_time,item_order_status) values(?,?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(orderItem.getOrderListId());
        params.add(orderItem.getProductId());
        params.add(orderItem.getProductCount());
        params.add(new Timestamp(new Date().getTime()));
        params.add(orderItem.getItemOrderStatus());
        List<Integer> list = updateBackIdList(sql, params);
        if (list!=null){
            return list.get(0);
        }
        return 0;
    }

    @Override
    public boolean udpdateOrderItemStatus(String orderStatus, Integer orderListId) {
        String sql="update order_item set item_order_status=? where order_list_id=?";
        List<Object> params=new ArrayList<>();
        params.add(orderStatus);
        params.add(orderListId);
        return update(sql,params);
    }

    @Override
    public boolean deleteOrderItem(Integer orderlistId) {
        String sql="delete from order_item where order_list_id=?";
        List<Object> params=new ArrayList<>();
        params.add(orderlistId);
        return update(sql,params);
    }

}
