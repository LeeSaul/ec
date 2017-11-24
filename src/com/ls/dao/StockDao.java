package com.ls.dao;

import com.ls.entity.InnerStock;
import com.ls.entity.Stock;

import java.util.List;

/**
 * Created by LS on 2017/9/13 21:58.
 * To Be or Not to Be
 */
public interface StockDao {
    //包含仓库、入库、出库信息

    //添加仓库信息
    boolean addStock(Stock stock);
    //更新仓库信息
    boolean updateStock(Stock stock);
    //增加入库记录
    boolean addInnerStock(InnerStock innerStock);
    //查看入库记录
    List<InnerStock> listInnerStock();

}
