package com.ls.service.impl;

import com.ls.dao.ShelfInfoDao;
import com.ls.dao.impl.ShelfInfoDaoImpl;
import com.ls.entity.ShelfInfo;
import com.ls.service.ShelfInfoService;

import java.util.List;

/**
 * Created by LS on 2017/9/15 8:52.
 * To Be or Not to Be
 */
public class ShelfInfoServiceImpl implements ShelfInfoService{
    ShelfInfoDao shelfInfoDao;

    public ShelfInfoServiceImpl() {
        shelfInfoDao=new ShelfInfoDaoImpl();
    }

    @Override
    public List<ShelfInfo> listShelfInfo() {
        return shelfInfoDao.listShelfInfo();
    }
}
