package com.ls.service;

import com.ls.entity.StockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/13 19:07.
 * To Be or Not to Be
 */
public interface StockInfoService {
    //��ѯ��Ʒ�ڲֿ��������Ϣ
    List<StockInfo> ListStockInfos();
    //������Ʒid���ҿ����Ϣ
    StockInfo findStockInfoByProductId(Integer productId);
}
