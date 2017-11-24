package com.ls.service.impl;

import com.ls.dao.StockDao;
import com.ls.dao.impl.StockDaoImpl;
import com.ls.entity.InnerStock;
import com.ls.entity.Stock;
import com.ls.service.StockService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/13 22:17.
 * To Be or Not to Be
 */
public class StockServiceImpl implements StockService{
    StockDao stockDao;

    public StockServiceImpl() {
        stockDao=new StockDaoImpl();
    }

    @Override
    public boolean addStock(Integer stockId,Integer productId, Integer adminId, Integer stockNumber, BigDecimal innerUnitPrice) {
        Stock stock=new Stock();
        stock.setProductId(productId);
        stock.setAdminId(adminId);
        stock.setStockNumber(stockNumber);
        stock.setStockUpdateTime(new Timestamp(new Date().getTime()));
        InnerStock innerStock=new InnerStock();
        innerStock.setAdminId(adminId);
        innerStock.setProductId(productId);
        innerStock.setInnerStockNumber(stockNumber);
        innerStock.setInnerTime(stock.getStockUpdateTime());
        innerStock.setInnerUnitPrice(innerUnitPrice);
        boolean b;
        if (stockId==null){
            b= stockDao.addStock(stock);
        }else {
            b = stockDao.updateStock(stock);
        }
        boolean b1=false;
        if (b){
             b1= stockDao.addInnerStock(innerStock);
        }
        System.out.println("------"+b+b1);
        return b&&b1;
    }

    @Override
    public List<InnerStock> listInnerStock() {
        return stockDao.listInnerStock();
    }

    @Override
    public boolean deleteStock(Integer productId, Integer buyNumber) {
        Stock stock=new Stock();
        stock.setProductId(productId);
        stock.setStockNumber(buyNumber);
        stock.setStockUpdateTime(new Timestamp(new Date().getTime()));
        return stockDao.updateStock(stock);
    }
}
