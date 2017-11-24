package com.ls.dao.impl;

import com.ls.dao.ShelfDao;
import com.ls.entity.Shelf;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/14 21:26.
 * To Be or Not to Be
 */
public class ShelfDaoImpl extends BaseDao implements ShelfDao{

    @Override
    public Integer insertShelf(Shelf shelf) {
        String sql="insert into shelf(product_id,admin_id,shelf_create_time,shelf_status) values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(shelf.getProductId());
        params.add(shelf.getAdminId());
        params.add(new Timestamp(new Date().getTime()));
        params.add(shelf.getShelfStatus());
        List<Integer> list = updateBackIdList(sql, params);
        if (list!=null){
            return list.get(0);
        }
        return 0;
    }

    @Override
    public boolean updateShelf(Shelf shelf) {
        String sql="update shelf set admin_id=?,shelf_create_time=?,shelf_status=? where product_id=?";
        List<Object> params=new ArrayList<>();
        params.add(shelf.getAdminId());
        params.add(new Timestamp(new Date().getTime()));
        params.add(shelf.getShelfStatus());
        params.add(shelf.getProductId());
        return update(sql,params);
    }

    @Override
    public Shelf findShelfByProductId(Integer productId) {
        String sql="select * form shelf where productId=?";
        List<Object> params=new ArrayList<>();
        params.add(productId);
        List<Shelf> query = query(sql, params, Shelf.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public Shelf findShelfByShelfId(Integer shelfId) {
        String sql="select * form shelf where shelfId=?";
        List<Object> params=new ArrayList<>();
        params.add(shelfId);
        List<Shelf> query = query(sql, params, Shelf.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }
}
