package com.ls.dao;

import com.ls.entity.OutStock;
import com.ls.entity.OutStockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/25 18:56.
 * To Be or Not to Be
 */
public interface OutStockInfoDao {
    //���ӳ����¼
    boolean addOutStockInfo(OutStock outStock);
    //��ʾ�����¼
    List<OutStockInfo> showOutStock();
}
