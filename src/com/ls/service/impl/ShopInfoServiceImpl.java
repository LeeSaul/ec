package com.ls.service.impl;

import com.ls.dao.ShopcartInfoDao;
import com.ls.dao.impl.ShopcartInfoDaoImpl;
import com.ls.entity.ShopcartInfo;
import com.ls.service.ShopcartInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/17 13:51.
 * To Be or Not to Be
 */
public class ShopInfoServiceImpl implements ShopcartInfoService{
    private ShopcartInfoDao shopcartInfoDao;

    public ShopInfoServiceImpl() {
        shopcartInfoDao=new ShopcartInfoDaoImpl();
    }

    @Override
    public List<ShopcartInfo> listShopcartInfosByCustomerId(Integer customerId) {
        return shopcartInfoDao.listShopcartInfosByCustomerId(customerId);
    }
}
