package com.ls.dao;

import com.ls.entity.Shelf;

/**
 * Created by LS on 2017/9/14 21:25.
 * To Be or Not to Be
 */
public interface ShelfDao {
    //�����ϼ���Ϣ
    Integer insertShelf(Shelf shelf);
    //�������¼���Ϣ
    boolean updateShelf(Shelf shelf);
    //ͨ����Ʒid�����Ƿ������¼ܼ�¼
    Shelf findShelfByProductId(Integer productId);
    //ͨ������id���Ҹ�����¼
    Shelf findShelfByShelfId(Integer shelfId);
}
