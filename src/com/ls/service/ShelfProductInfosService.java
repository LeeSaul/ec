package com.ls.service;

import com.ls.entity.ShelfProductInfos;

import java.util.List;

/**
 * Created by LS on 2017/9/17 7:52.
 * To Be or Not to Be
 */
public interface ShelfProductInfosService {
    //显示所有已上架商品
    List<ShelfProductInfos> listAllShelfProductInfos(Integer number,Integer page);
    //通过id查找某上商品详情
    ShelfProductInfos findShelfProductInfoByProductId(Integer productId);
}

