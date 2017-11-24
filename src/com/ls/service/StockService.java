package com.ls.service;

import com.ls.entity.InnerStock;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/9/13 22:17.
 * To Be or Not to Be
 */
public interface StockService {
    //�����ֿ⡢��⡢������Ϣ

    //��Ӳֿ���Ϣ(�����Ƿ���ڶ�Ӧ�Ĳֿ�id���ж�����ӻ��Ǹ���)
    boolean addStock(Integer stockId, Integer productId, Integer adminId, Integer stockNumber, BigDecimal productPrice);
    //�鿴����¼
    List<InnerStock> listInnerStock();
    //���ٲֿ��¼
    boolean deleteStock(Integer productId,Integer buyNumber);
}
