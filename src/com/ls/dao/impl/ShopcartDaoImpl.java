package com.ls.dao.impl;

import com.ls.dao.ShopcartDao;
import com.ls.entity.Shopcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/17 12:22.
 * To Be or Not to Be
 */
public class ShopcartDaoImpl extends BaseDao implements ShopcartDao{
    @Override
    public int addProductToCartBackId(Shopcart shopcart) {
        String sql="insert into shopcart(customer_id,product_id,product_cart_count,create_cart_time) values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(shopcart.getCustomerId());
        params.add(shopcart.getProductId());
        params.add(shopcart.getProductCartCount());
        params.add(shopcart.getCreateCartTime());
        List<Integer> list = updateBackIdList(sql, params);
        if (list!=null){
            return list.get(0);
        }
        return 0;
    }

    @Override
    public Shopcart findShopcartByCustomerIdAndProductId(Integer customerId, Integer productId) {
        String sql="select * from shopcart where customer_id=? AND product_id=?";
        List<Object> params=new ArrayList<>();
        params.add(customerId);
        params.add(productId);
        List<Shopcart> query = query(sql, params, Shopcart.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public boolean updateShopcartById(Integer productCartCount,Integer id) {
        String sql="update shopcart set product_cart_count=product_cart_count+? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(productCartCount);
        params.add(id);
        return update(sql, params);
    }

    @Override
    public boolean updateShopcartAddAndDecrease(Integer count, Integer id) {
        String sql="update shopcart set product_cart_count=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(count);
        params.add(id);
        return update(sql, params);
    }

    @Override
    public boolean deleteShopcartByCustomerId(Integer customerId) {
        String sql="delete from shopcart where customer_id=?";
        List<Object> params=new ArrayList<>();
        params.add(customerId);
        return update(sql,params);
    }

    @Override
    public boolean deleteShopcartByShopcartId(Integer shopcartId) {
        String sql="delete from shopcart where id=?";
        List<Object> params=new ArrayList<>();
        params.add(shopcartId);
        return update(sql,params);
    }
}
