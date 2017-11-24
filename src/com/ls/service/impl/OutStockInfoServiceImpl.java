package com.ls.service.impl;

import com.ls.dao.OutStockInfoDao;
import com.ls.dao.impl.OutStockInfoDaoImpl;
import com.ls.entity.OutStock;
import com.ls.entity.OutStockInfo;
import com.ls.service.OutStockInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/25 19:27.
 * To Be or Not to Be
 */
public class OutStockInfoServiceImpl implements OutStockInfoService {
    private OutStockInfoDao outStockInfoDao;

    public OutStockInfoServiceImpl() {
        outStockInfoDao=new OutStockInfoDaoImpl();
    }

    @Override
    public boolean addOutStockInfo(OutStock outStock) {
        return outStockInfoDao.addOutStockInfo(outStock);
    }

    @Override
    public List<OutStockInfo> showOutStock() {
        return outStockInfoDao.showOutStock();
    }
}
