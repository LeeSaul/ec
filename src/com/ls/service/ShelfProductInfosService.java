package com.ls.service;

import com.ls.entity.ShelfProductInfos;

import java.util.List;

/**
 * Created by LS on 2017/9/17 7:52.
 * To Be or Not to Be
 */
public interface ShelfProductInfosService {
    //��ʾ�������ϼ���Ʒ
    List<ShelfProductInfos> listAllShelfProductInfos(Integer number,Integer page);
    //ͨ��id����ĳ����Ʒ����
    ShelfProductInfos findShelfProductInfoByProductId(Integer productId);
}

