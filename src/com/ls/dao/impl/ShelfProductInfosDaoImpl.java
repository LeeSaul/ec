package com.ls.dao.impl;

import com.ls.dao.ShelfProductInfosDao;
import com.ls.entity.Shelf;
import com.ls.entity.ShelfProductInfos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/17 7:42.
 * To Be or Not to Be
 */
public class ShelfProductInfosDaoImpl extends BaseDao implements ShelfProductInfosDao{
    @Override
    public List<ShelfProductInfos> listAllShelfProductInfos(Integer start,Integer end) {
        String sql="select pr.id pId,product_name,product_price,product_type,small_image,big_image,product_caption,stock_number from product pr left join product_detail pd on pr.id = pd.product_id LEFT JOIN stock st ON pr.id = st.product_id LEFT JOIN shelf sh ON pr.id = sh.product_id where sh.shelf_status=? limit ?,?";
        List<Object> params=new ArrayList<>();
        params.add(Shelf.SHELF_ON);
        params.add(start);
        params.add(end);
        List<ShelfProductInfos> shelfProductInfos = query(sql, params, ShelfProductInfos.class);
        return shelfProductInfos;
    }

    @Override
    public ShelfProductInfos findShelfProductInfoByProductId(Integer productId) {
        String sql="select pr.id pId,product_name,product_price,product_type,small_image,big_image,product_caption,stock_number from product pr left join product_detail pd on pr.id = pd.product_id LEFT JOIN stock st ON pr.id = st.product_id LEFT JOIN shelf sh ON pr.id = sh.product_id where pr.id=?";
        List<Object> params=new ArrayList<>();
        params.add(productId);
        List<ShelfProductInfos> query = query(sql, params, ShelfProductInfos.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }
}
