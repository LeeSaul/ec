package com.ls.service;

import com.ls.entity.ShopcartInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/17 13:50.
 * To Be or Not to Be
 */
public interface ShopcartInfoService {
    //��ʾ��ǰ�û��Ĺ��ﳵ
    List<ShopcartInfo> listShopcartInfosByCustomerId(Integer customerId);
}
