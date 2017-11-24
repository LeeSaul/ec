package com.ls.dao;

import com.ls.entity.Shopcart;

/**
 * Created by LS on 2017/9/17 12:22.
 * To Be or Not to Be
 */
public interface ShopcartDao {
    //添加商品到购物车
    int addProductToCartBackId(Shopcart shopcart);
    //判断某个商品是否已经在购物车
    Shopcart findShopcartByCustomerIdAndProductId(Integer customerId,Integer productId);
    //通过购物车id更新信息（在原来基础上增加）
    boolean updateShopcartById(Integer productCartCount,Integer id);
    //通过购物车id更新信息（在原来基础上增加或者是减少）
    boolean updateShopcartAddAndDecrease(Integer count,Integer id);
    //清空购物车
    boolean deleteShopcartByCustomerId(Integer customerId);
    //删除购物车某一条记录
    boolean deleteShopcartByShopcartId(Integer shopcartId);
}
