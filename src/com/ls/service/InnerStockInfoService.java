package com.ls.service;

import com.ls.entity.InnerStockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/14 8:52.
 * To Be or Not to Be
 */
public interface InnerStockInfoService {
    //查看所有入库记录
    List<InnerStockInfo> listInnerStockInfo();
}
