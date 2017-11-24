package com.ls.dao.impl;

import com.ls.dao.InnerStockInfoDao;
import com.ls.entity.InnerStockInfo;

import java.util.List;

/**
 * Created by LS on 2017/9/14 8:43.
 * To Be or Not to Be
 */
public class InnerStockInfoDaoImpl extends BaseDao implements InnerStockInfoDao{
    @Override
    public List<InnerStockInfo> listInnerStockInfo() {
        String sql="select ad.admin_name,pr.product_name,ins.inner_unit_price,ins.inner_stock_number,ins.inner_time " +
                "from inner_stock ins left join admin ad on ins.admin_id=ad.id left join product pr on ins.product_id=pr.id";
        List<InnerStockInfo> innerStockInfos = query(sql, null, InnerStockInfo.class);
        return innerStockInfos;
    }
}
