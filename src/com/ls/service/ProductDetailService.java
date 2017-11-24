package com.ls.service;

import com.ls.entity.Product;
import com.ls.entity.ProductDetail;

/**
 * Created by LS on 2017/9/12 8:26.
 * To Be or Not to Be
 */
public interface ProductDetailService {
    //增加商品详细
    boolean addProductDetail(ProductDetail productDetail);
    //查找商品详细
    ProductDetail findProductDetailByProductId(int productId);
    //更新商品详情
    boolean updateProductDetail(ProductDetail productDetail);
}
