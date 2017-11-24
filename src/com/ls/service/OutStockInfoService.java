package com.ls.service;

import com.ls.entity.OutStock;
import com.ls.entity.OutStockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/25 19:26.
 * To Be or Not to Be
 */
public interface OutStockInfoService {
    //增加出库记录
    boolean addOutStockInfo(OutStock outStock);
    //显示出库记录
    List<OutStockInfo> showOutStock();
}
