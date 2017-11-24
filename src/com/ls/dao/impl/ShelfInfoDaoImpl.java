package com.ls.dao.impl;

import com.ls.dao.ShelfInfoDao;
import com.ls.entity.ShelfInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/15 8:35.
 * To Be or Not to Be
 */
public class ShelfInfoDaoImpl extends BaseDao implements ShelfInfoDao{
    @Override
    public List<ShelfInfo> listShelfInfo() {
        String sql="select pr.id productId,pr.product_name,pr.product_price,st.stock_number,sh.shelf_create_time,sh.shelf_status,ad.admin_name from product pr LEFT JOIN stock st on pr.id=st.product_id LEFT JOIN shelf sh on pr.id=sh.product_id LEFT JOIN admin ad on ad.id=sh.admin_id";
        List<Object> params=new ArrayList<>();
        List<ShelfInfo> query = query(sql, params, ShelfInfo.class);
        return query;
    }
}
