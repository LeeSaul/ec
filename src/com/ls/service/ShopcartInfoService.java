package com.ls.service;

import com.ls.entity.ShopcartInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/17 13:50.
 * To Be or Not to Be
 */
public interface ShopcartInfoService {
    //显示当前用户的购物车
    List<ShopcartInfo> listShopcartInfosByCustomerId(Integer customerId);
}
