package com.ls.dao;

import com.ls.entity.Shopcart;

/**
 * Created by LS on 2017/9/17 12:22.
 * To Be or Not to Be
 */
public interface ShopcartDao {
    //�����Ʒ�����ﳵ
    int addProductToCartBackId(Shopcart shopcart);
    //�ж�ĳ����Ʒ�Ƿ��Ѿ��ڹ��ﳵ
    Shopcart findShopcartByCustomerIdAndProductId(Integer customerId,Integer productId);
    //ͨ�����ﳵid������Ϣ����ԭ�����������ӣ�
    boolean updateShopcartById(Integer productCartCount,Integer id);
    //ͨ�����ﳵid������Ϣ����ԭ�����������ӻ����Ǽ��٣�
    boolean updateShopcartAddAndDecrease(Integer count,Integer id);
    //��չ��ﳵ
    boolean deleteShopcartByCustomerId(Integer customerId);
    //ɾ�����ﳵĳһ����¼
    boolean deleteShopcartByShopcartId(Integer shopcartId);
}
