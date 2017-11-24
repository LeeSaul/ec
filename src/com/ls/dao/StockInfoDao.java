package com.ls.dao;

import com.ls.entity.StockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/13 18:40.
 * To Be or Not to Be
 */
public interface StockInfoDao {
    //显示所有的商品信息包括库存
    List<StockInfo> ListStockInfos();
    //根据商品id查找库存信息
    StockInfo findStockInfoByProductId(Integer productId);
}
