package com.ls.dao.impl;

import com.ls.dao.ProductDetailDao;
import com.ls.entity.ProductDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/12 7:30.
 * To Be or Not to Be
 */
public class ProductDetailDaoImpl extends BaseDao implements ProductDetailDao {
    @Override
    public boolean addProductDetail(ProductDetail productDetail) {
        String sql = "insert into product_detail(product_id,small_image,big_image,product_caption) values(?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(productDetail.getProductId());
        params.add(productDetail.getSmallImage());
        params.add(productDetail.getBigImage());
        params.add(productDetail.getProductCaption());
        return update(sql, params);
    }

    @Override
    public ProductDetail findProductDetailByProductId(int productId) {
        String sql = "select * from product_detail where product_id=?";
        List<Object> params = new ArrayList<>();
        params.add(productId);
        List<ProductDetail> prductDetails = query(sql, params, ProductDetail.class);
        if (prductDetails != null) {
            return prductDetails.get(0);
        }
        return null;
    }

    @Override
    public boolean updateSmallImage(ProductDetail productDetail) {
        String sql="update product_detail set small_image=?,product_caption=? where product_id=?";
        List<Object> params = new ArrayList<>();
        params.add(productDetail.getSmallImage());
        params.add(productDetail.getProductCaption());
        params.add(productDetail.getProductId());
        return update(sql,params);
    }

    @Override
    public boolean updateBigImage(ProductDetail productDetail) {
        String sql="update product_detail set big_image=?,product_caption=? where product_id=?";
        List<Object> params = new ArrayList<>();
        params.add(productDetail.getBigImage());
        params.add(productDetail.getProductCaption());
        params.add(productDetail.getProductId());
        return update(sql,params);
    }

    @Override
    public boolean updateSmallAndBigImage(ProductDetail productDetail) {
        String sql="update product_detail set small_image=?,big_image=?,product_caption=? where product_id=?";
        List<Object> params = new ArrayList<>();
        params.add(productDetail.getSmallImage());
        params.add(productDetail.getBigImage());
        params.add(productDetail.getProductCaption());
        params.add(productDetail.getProductId());
        return update(sql,params);
    }

    @Override
    public boolean updateCaption(ProductDetail productDetail) {
        String sql="update product_detail set product_caption=? where product_id=?";
        List<Object> params = new ArrayList<>();
        params.add(productDetail.getProductCaption());
        params.add(productDetail.getProductId());
        return update(sql,params);
    }
}