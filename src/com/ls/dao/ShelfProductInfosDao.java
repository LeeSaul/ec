package com.ls.dao;

import com.ls.entity.ShelfProductInfos;

import java.util.List;

/**
 * Created by LS on 2017/9/17 7:41.
 * To Be or Not to Be
 */
public interface ShelfProductInfosDao {
    //��ʾ�������ϼ���Ʒ
    List<ShelfProductInfos> listAllShelfProductInfos(Integer start,Integer end);
    //ͨ��id����ĳ����Ʒ����
    ShelfProductInfos findShelfProductInfoByProductId(Integer productId);
}
