package com.ls.dao;

import com.ls.entity.ProductDetail;

/**
 * Created by LS on 2017/9/12 7:30.
 * To Be or Not to Be
 */
public interface ProductDetailDao {
    //添加商品详情
    boolean addProductDetail(ProductDetail productDetail);
    //通过商品id查找到该商品的详细信息
    ProductDetail findProductDetailByProductId(int productId);
    //通过商品id更新商品的小图片
    boolean updateSmallImage(ProductDetail productDetail);
    //通过商品id更新商品的大图片
    boolean updateBigImage(ProductDetail productDetail);
    //通过商品id更新商品的大小图片
    boolean updateSmallAndBigImage(ProductDetail productDetail);
    //通过商品id只更新商品说明
    boolean updateCaption(ProductDetail productDetail);
}
