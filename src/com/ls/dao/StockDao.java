package com.ls.dao;

import com.ls.entity.InnerStock;
import com.ls.entity.Stock;

import java.util.List;

/**
 * Created by LS on 2017/9/13 21:58.
 * To Be or Not to Be
 */
public interface StockDao {
    //�����ֿ⡢��⡢������Ϣ

    //��Ӳֿ���Ϣ
    boolean addStock(Stock stock);
    //���²ֿ���Ϣ
    boolean updateStock(Stock stock);
    //��������¼
    boolean addInnerStock(InnerStock innerStock);
    //�鿴����¼
    List<InnerStock> listInnerStock();

}
