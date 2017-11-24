package com.ls.dao.impl;

import com.ls.dao.OrderListDao;
import com.ls.entity.OrderList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/18 15:32.
 * To Be or Not to Be
 */
public class OrderListDaoImpl extends BaseDao implements OrderListDao{
    @Override
    public Integer addOrderListBackId(OrderList orderList) {
        String sql = "insert into order_list(customer_id,address_id,total_money,order_create_time) values(?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(orderList.getCustomerId());
        params.add(orderList.getAddressId());
        params.add(orderList.getTotalMoney());
        params.add(new Timestamp(new Date().getTime()));
        List<Integer> list = updateBackIdList(sql, params);
        if (list != null) {
            return list.get(0);
        }
        return 0;
    }

    @Override
    public boolean updateOrderListStatus(String status,Integer orderListId) {
        String sql="update order_list set order_status=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(status);
        params.add(orderListId);
        return update(sql,params);
    }

    @Override
    public boolean deleteOrderList(Integer orderlistId) {
        String sql="delete from order_list where id=?";
        List<Object> params=new ArrayList<>();
        params.add(orderlistId);
        return update(sql,params);
    }
}
