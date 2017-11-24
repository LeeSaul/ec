package com.ls.service.impl;

import com.ls.dao.StockInfoDao;
import com.ls.dao.impl.StockInfoDaoImpl;
import com.ls.entity.StockInfo;
import com.ls.service.StockInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/13 19:08.
 * To Be or Not to Be
 */
public class StockInfoServiceImpl implements StockInfoService{
    StockInfoDao stockInfoDao;

    public StockInfoServiceImpl() {
        stockInfoDao=new StockInfoDaoImpl();
    }

    @Override
    public List<StockInfo> ListStockInfos() {
        return stockInfoDao.ListStockInfos();
    }

    @Override
    public StockInfo findStockInfoByProductId(Integer productId) {
        return stockInfoDao.findStockInfoByProductId(productId);
    }
}
