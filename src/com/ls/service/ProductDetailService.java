package com.ls.service;

import com.ls.entity.Product;
import com.ls.entity.ProductDetail;

/**
 * Created by LS on 2017/9/12 8:26.
 * To Be or Not to Be
 */
public interface ProductDetailService {
    //������Ʒ��ϸ
    boolean addProductDetail(ProductDetail productDetail);
    //������Ʒ��ϸ
    ProductDetail findProductDetailByProductId(int productId);
    //������Ʒ����
    boolean updateProductDetail(ProductDetail productDetail);
}
