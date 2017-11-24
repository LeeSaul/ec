package com.ls.service.impl;

import com.ls.dao.InnerStockInfoDao;
import com.ls.dao.impl.InnerStockInfoDaoImpl;
import com.ls.entity.InnerStockInfo;
import com.ls.service.InnerStockInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/14 8:52.
 * To Be or Not to Be
 */
public class InnerStockInfoServiceImpl implements InnerStockInfoService{
    private InnerStockInfoDao innerStockInfoDao;

    public InnerStockInfoServiceImpl() {
        innerStockInfoDao=new InnerStockInfoDaoImpl();
    }

    @Override
    public List<InnerStockInfo> listInnerStockInfo() {
        return innerStockInfoDao.listInnerStockInfo();
    }
}
