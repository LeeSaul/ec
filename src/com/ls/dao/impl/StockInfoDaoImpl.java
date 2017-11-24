package com.ls.dao.impl;

import com.ls.dao.StockInfoDao;
import com.ls.entity.StockInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/13 18:50.
 * To Be or Not to Be
 */
public class StockInfoDaoImpl extends BaseDao implements StockInfoDao {
    @Override
    public List<StockInfo> ListStockInfos() {
        String sql="select p.id pId,p.product_name productName,p.product_price productPrice,p.product_type productType,s.id stockId,s.product_id productId,s.admin_id adminId,s.stock_number stockNumber,s.stock_update_time stockUpdateTime " +
                "from product p LEFT JOIN stock s ON p.id=s.product_id";
        List<StockInfo> stockInfos = query(sql, null, StockInfo.class);
        return stockInfos;
    }

    @Override
    public StockInfo findStockInfoByProductId(Integer productId) {
        String sql="select p.id pId,p.product_name productName,p.product_price productPrice,p.product_type productType,s.id stockId,s.stock_number stockNumber " +
                "from product p LEFT JOIN stock s ON p.id=s.product_id where p.id=?";
        List<Object> params=new ArrayList<>();
        params.add(productId);
        List<StockInfo> stockInfos = query(sql, params, StockInfo.class);
        if (stockInfos!=null){
            return stockInfos.get(0);
        }
        return null;
    }
}
