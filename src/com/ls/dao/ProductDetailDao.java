package com.ls.dao;

import com.ls.entity.ProductDetail;

/**
 * Created by LS on 2017/9/12 7:30.
 * To Be or Not to Be
 */
public interface ProductDetailDao {
    //�����Ʒ����
    boolean addProductDetail(ProductDetail productDetail);
    //ͨ����Ʒid���ҵ�����Ʒ����ϸ��Ϣ
    ProductDetail findProductDetailByProductId(int productId);
    //ͨ����Ʒid������Ʒ��СͼƬ
    boolean updateSmallImage(ProductDetail productDetail);
    //ͨ����Ʒid������Ʒ�Ĵ�ͼƬ
    boolean updateBigImage(ProductDetail productDetail);
    //ͨ����Ʒid������Ʒ�Ĵ�СͼƬ
    boolean updateSmallAndBigImage(ProductDetail productDetail);
    //ͨ����Ʒidֻ������Ʒ˵��
    boolean updateCaption(ProductDetail productDetail);
}
