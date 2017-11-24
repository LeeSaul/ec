package com.ls.service;

import com.ls.entity.StockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/13 19:07.
 * To Be or Not to Be
 */
public interface StockInfoService {
    //查询商品在仓库里面的信息
    List<StockInfo> ListStockInfos();
    //根据商品id查找库存信息
    StockInfo findStockInfoByProductId(Integer productId);
}
