package com.ls.dao;

import com.ls.entity.StockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/13 18:40.
 * To Be or Not to Be
 */
public interface StockInfoDao {
    //��ʾ���е���Ʒ��Ϣ�������
    List<StockInfo> ListStockInfos();
    //������Ʒid���ҿ����Ϣ
    StockInfo findStockInfoByProductId(Integer productId);
}
