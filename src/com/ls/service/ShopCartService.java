package com.ls.service;

import com.ls.entity.Shopcart;

/**
 * Created by LS on 2017/9/17 12:32.
 * To Be or Not to Be
 */
public interface ShopCartService {
    //�����Ʒ�����ﳵ
    int addProductToCartBackId(Integer customerId,Integer productId,Integer productCartCount);
    //�ж�ĳ����Ʒ�Ƿ��Ѿ��ڹ��ﳵ
    Shopcart findShopcartByCustomerIdAndProductId(Integer customerId, Integer productId);
    //ͨ�����ﳵid������Ϣ�����ӣ�
    boolean updateShopcartById(Integer productCartCount,Integer id);
    //ͨ�����ﳵid������Ϣ����ԭ�����������ӻ����Ǽ��٣�
    boolean updateShopcartAddAndDecrease(Integer count,Integer id);
    //��չ��ﳵ
    boolean deleteShopcartByCustomerId(Integer customerId);
    //ɾ�����ﳵĳһ����¼
    boolean deleteShopcartByShopcartId(Integer shopcartId);
}
