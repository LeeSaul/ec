package com.ls.dao.impl;

import com.ls.dao.OrderListInfoDao;
import com.ls.entity.OrderList;
import com.ls.entity.OrderListInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/20 7:47.
 * To Be or Not to Be
 */
public class OrderListInfoDaoImpl extends BaseDao implements OrderListInfoDao{
    @Override
    public List<OrderListInfo> ListOrders(Integer customerId) {
        String sql="select oi.id order_item_id,product_name,product_price,small_image,total_money,order_status,order_create_time,order_list_id,oi.product_id,product_count,item_order_status from order_list ol left join customer cu on ol.customer_id = cu.id LEFT JOIN order_item oi ON ol.id = oi.order_list_id LEFT JOIN product pr ON oi.product_id = pr.id LEFT JOIN address ad ON ol.address_id = ad.id LEFT JOIN product_detail pd ON pr.id = pd.product_id where ad.customer_id=?";
        List<Object> params=new ArrayList<>();
        params.add(customerId);
        List<OrderListInfo> query = query(sql, params, OrderListInfo.class);
        return query;
    }

    @Override
    public OrderListInfo OrderDetails(Integer orderItemId) {
        String sql="select product_name,product_price,small_image,order_status,order_create_time,order_list_id,product_count,item_order_status,province,city,county,road,ad.address_phone,ad.address_receiver from order_list ol left join customer cu on ol.customer_id = cu.id LEFT JOIN order_item oi ON ol.id = oi.order_list_id LEFT JOIN product pr ON oi.product_id = pr.id LEFT JOIN address ad ON ol.address_id = ad.id LEFT JOIN product_detail pd ON pr.id = pd.product_id where oi.id=?";
        List<Object> params=new ArrayList<>();
        params.add(orderItemId);
        List<OrderListInfo> query = query(sql, params, OrderListInfo.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public List<OrderListInfo> ListOrdersByStatus(String status) {
        String sql="select oi.id order_item_id,product_name,product_price,small_image,total_money,order_status,order_create_time,order_list_id,oi.product_id,product_count,item_order_status from order_list ol left join customer cu on ol.customer_id = cu.id LEFT JOIN order_item oi ON ol.id = oi.order_list_id LEFT JOIN product pr ON oi.product_id = pr.id LEFT JOIN address ad ON ol.address_id = ad.id LEFT JOIN product_detail pd ON pr.id = pd.product_id where order_status=?";
        List<Object> params=new ArrayList<>();
        params.add(status);
        List<OrderListInfo> query = query(sql, params, OrderListInfo.class);
        return query;
    }

    @Override
    public List<OrderListInfo> ListOrders() {
        String sql="select oi.id order_item_id,product_name,product_price,small_image,total_money,order_status,order_create_time,order_list_id,oi.product_id,product_count,item_order_status from order_list ol left join customer cu on ol.customer_id = cu.id LEFT JOIN order_item oi ON ol.id = oi.order_list_id LEFT JOIN product pr ON oi.product_id = pr.id LEFT JOIN address ad ON ol.address_id = ad.id LEFT JOIN product_detail pd ON pr.id = pd.product_id";
        List<OrderListInfo> query = query(sql,null, OrderListInfo.class);
        return query;
    }

    @Override
    public List<OrderListInfo> ListCustomerOrdersByStatus(String status, Integer customerId) {
        String sql="select oi.id order_item_id,product_name,product_price,small_image,total_money,order_status,order_create_time,order_list_id,oi.product_id,product_count,item_order_status from order_list ol left join customer cu on ol.customer_id = cu.id LEFT JOIN order_item oi ON ol.id = oi.order_list_id LEFT JOIN product pr ON oi.product_id = pr.id LEFT JOIN address ad ON ol.address_id = ad.id LEFT JOIN product_detail pd ON pr.id = pd.product_id where order_status=? and ol.customer_id=?";
        List<Object> params=new ArrayList<>();
        params.add(status);
        params.add(customerId);
        List<OrderListInfo> query = query(sql, params, OrderListInfo.class);
        return query;
    }
}
