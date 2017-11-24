package com.ls.dao.impl;

import com.ls.dao.OutStockInfoDao;
import com.ls.entity.OutStock;
import com.ls.entity.OutStockInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/25 19:07.
 * To Be or Not to Be
 */
public class OutStockInfoDaoImpl extends BaseDao implements OutStockInfoDao {
    @Override
    public boolean addOutStockInfo(OutStock outStock) {
        String sql="insert into out_stock(product_id,admin_id,out_stock_number,out_time,out_unit_price) values(?,?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(outStock.getProductId());
        params.add(outStock.getAdminId());
        params.add(outStock.getOutStockNumber());
        params.add(outStock.getOut_Time());
        params.add(outStock.getOutUnitPrice());
        return update(sql,params);
    }

    @Override
    public List<OutStockInfo> showOutStock() {
        String sql="select admin_name name,product_name,out_unit_price,out_stock_number,out_time from out_stock LEFT JOIN product ON out_stock.product_id = product.id LEFT JOIN stock ON product.id = stock.product_id LEFT JOIN admin ON out_stock.admin_id = admin.id";
        List<OutStockInfo> query = query(sql, null, OutStockInfo.class);
        return query;
    }
}
