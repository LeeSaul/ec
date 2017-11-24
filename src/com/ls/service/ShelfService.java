package com.ls.service;

import com.ls.entity.Shelf;

/**
 * Created by LS on 2017/9/14 22:13.
 * To Be or Not to Be
 */
public interface ShelfService {
    //插入一条上架信息（第一次）
    Integer onShelf(Integer productId,Integer adminId);
    //上架
    boolean turnOnShelf(Integer productId,Integer adminId);
    //下架
    boolean turnOffShelf(Integer productId,Integer adminId);
    //通过商品id查找记录
    Shelf findShelfByProductId(Integer productId);
    //通过货架id查找是否有上下架记录
    Shelf findShelfByShelfId(Integer shelfId);
}
