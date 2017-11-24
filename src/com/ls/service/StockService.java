package com.ls.service;

import com.ls.entity.InnerStock;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/9/13 22:17.
 * To Be or Not to Be
 */
public interface StockService {
    //包含仓库、入库、出库信息

    //添加仓库信息(根据是否存在对应的仓库id，判断是添加还是更新)
    boolean addStock(Integer stockId, Integer productId, Integer adminId, Integer stockNumber, BigDecimal productPrice);
    //查看入库记录
    List<InnerStock> listInnerStock();
    //减少仓库记录
    boolean deleteStock(Integer productId,Integer buyNumber);
}
