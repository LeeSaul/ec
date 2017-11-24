package com.ls.service.impl;

import com.ls.dao.ShelfProductInfosDao;
import com.ls.dao.impl.ShelfProductInfosDaoImpl;
import com.ls.entity.ShelfProductInfos;
import com.ls.service.ShelfProductInfosService;

import java.util.List;

/**
 * Created by LS on 2017/9/17 7:53.
 * To Be or Not to Be
 */
public class ShelfProductInfosServiceImpl implements ShelfProductInfosService{
    private ShelfProductInfosDao shelfProductInfosDao;

    public ShelfProductInfosServiceImpl() {
        shelfProductInfosDao=new ShelfProductInfosDaoImpl();
    }

    @Override
    public List<ShelfProductInfos> listAllShelfProductInfos(Integer number,Integer page) {
        Integer start=number*(page-1);
        Integer end=start+number;
        return shelfProductInfosDao.listAllShelfProductInfos(start,end);
    }

    @Override
    public ShelfProductInfos findShelfProductInfoByProductId(Integer productId) {
        return shelfProductInfosDao.findShelfProductInfoByProductId(productId);
    }
}
