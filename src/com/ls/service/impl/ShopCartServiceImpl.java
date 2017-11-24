package com.ls.service.impl;

import com.ls.dao.ShopcartDao;
import com.ls.dao.impl.ShopcartDaoImpl;
import com.ls.entity.Shopcart;
import com.ls.service.ShopCartService;

import java.sql.Timestamp;
/**
 * Created by LS on 2017/9/17 12:32.
 * To Be or Not to Be
 */
public class ShopCartServiceImpl implements ShopCartService{
    private ShopcartDao shopcartDao;

    public ShopCartServiceImpl() {
        shopcartDao=new ShopcartDaoImpl();
    }

    @Override
    public int addProductToCartBackId(Integer customerId,Integer productId,Integer productCartCount) {
        Shopcart shopcart=new Shopcart();
        shopcart.setCustomerId(customerId);
        shopcart.setProductId(productId);
        shopcart.setProductCartCount(productCartCount);
        shopcart.setCreateCartTime(new Timestamp(System.currentTimeMillis()));
        return shopcartDao.addProductToCartBackId(shopcart);
    }

    @Override
    public Shopcart findShopcartByCustomerIdAndProductId(Integer customerId, Integer productId) {
        return shopcartDao.findShopcartByCustomerIdAndProductId(customerId,productId);
    }

    @Override
    public boolean updateShopcartById(Integer productCartCount, Integer id) {
        return shopcartDao.updateShopcartById(productCartCount,id);
    }

    @Override
    public boolean updateShopcartAddAndDecrease(Integer count, Integer id) {
        return shopcartDao.updateShopcartAddAndDecrease(count,id);
    }

    @Override
    public boolean deleteShopcartByCustomerId(Integer customerId) {
        return shopcartDao.deleteShopcartByCustomerId(customerId);
    }

    @Override
    public boolean deleteShopcartByShopcartId(Integer shopcartId) {
        return shopcartDao.deleteShopcartByShopcartId(shopcartId);
    }
}
