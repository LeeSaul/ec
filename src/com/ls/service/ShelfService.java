package com.ls.service;

import com.ls.entity.Shelf;

/**
 * Created by LS on 2017/9/14 22:13.
 * To Be or Not to Be
 */
public interface ShelfService {
    //����һ���ϼ���Ϣ����һ�Σ�
    Integer onShelf(Integer productId,Integer adminId);
    //�ϼ�
    boolean turnOnShelf(Integer productId,Integer adminId);
    //�¼�
    boolean turnOffShelf(Integer productId,Integer adminId);
    //ͨ����Ʒid���Ҽ�¼
    Shelf findShelfByProductId(Integer productId);
    //ͨ������id�����Ƿ������¼ܼ�¼
    Shelf findShelfByShelfId(Integer shelfId);
}
