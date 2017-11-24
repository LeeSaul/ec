package com.ls.dao.impl;

import com.ls.dao.ShopcartInfoDao;
import com.ls.entity.ShopcartInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/17 13:40.
 * To Be or Not to Be
 */
public class ShopcartInfoDaoImpl extends BaseDao implements ShopcartInfoDao{
    @Override
    public List<ShopcartInfo> listShopcartInfosByCustomerId(Integer customerId) {
        String sql="select sh.id shopcart_id,pr.id pId,stock_number,pr.product_name,pr.product_price,prd.small_image,sh.product_cart_count,she.shelf_status from shopcart sh LEFT JOIN product pr on sh.product_id = pr.id LEFT JOIN shelf she ON pr.id = she.product_id left join product_detail prd on prd.product_id=pr.id left join stock on pr.id=stock.product_id where sh.customer_id=?";
        List<Object> params=new ArrayList<>();
        params.add(customerId);
        List<ShopcartInfo> query = query(sql, params, ShopcartInfo.class);
        return query;
    }
}
