package com.ls.dao;

import com.ls.entity.Shelf;

/**
 * Created by LS on 2017/9/14 21:25.
 * To Be or Not to Be
 */
public interface ShelfDao {
    //增加上架信息
    Integer insertShelf(Shelf shelf);
    //更新上下架信息
    boolean updateShelf(Shelf shelf);
    //通过商品id查找是否有上下架记录
    Shelf findShelfByProductId(Integer productId);
    //通过货架id查找该条记录
    Shelf findShelfByShelfId(Integer shelfId);
}
