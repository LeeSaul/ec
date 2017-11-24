package com.ls.dao;

import com.ls.entity.ShelfInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/15 8:35.
 * To Be or Not to Be
 */
public interface ShelfInfoDao {
    //查看货架信息
    List<ShelfInfo> listShelfInfo();
}
