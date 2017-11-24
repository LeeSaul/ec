package com.ls.dao.impl;

import com.ls.dao.StockDao;
import com.ls.entity.InnerStock;
import com.ls.entity.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/13 21:58.
 * To Be or Not to Be
 */
public class StockDaoImpl extends BaseDao implements StockDao{
    @Override
    public boolean addStock(Stock stock) {
        String sql="insert into stock(product_id,admin_id,stock_number,stock_update_time) values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(stock.getProductId());
        params.add(stock.getAdminId());
        params.add(stock.getStockNumber());
        params.add(stock.getStockUpdateTime());
        return update(sql,params);
    }

    @Override
    public boolean updateStock(Stock stock) {
        String sql="update stock set stock_number=stock_number+?,stock_update_time=? where product_id=?";
        List<Object> params=new ArrayList<>();
        params.add(stock.getStockNumber());
        params.add(stock.getStockUpdateTime());
        params.add(stock.getProductId());
        return update(sql,params);
    }

    @Override
    public boolean addInnerStock(InnerStock innerStock) {
        String sql="insert into inner_stock(product_id,admin_id,inner_stock_number,inner_time,inner_unit_price) values(?,?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(innerStock.getProductId());
        params.add(innerStock.getAdminId());
        params.add(innerStock.getInnerStockNumber());
        params.add(innerStock.getInnerTime());
        params.add(innerStock.getInnerUnitPrice());
        return update(sql,params);
    }

    @Override
    public List<InnerStock> listInnerStock() {
        String sql="select * from inner_stock";
        List<InnerStock> innerStocks = query(sql, null, InnerStock.class);
        return innerStocks;
    }
}
