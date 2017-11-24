package com.ls.service;

import com.ls.entity.Product;

import java.util.List;

/**
 * Created by LS on 2017/9/12 7:32.
 * To Be or Not to Be
 */
public interface ProductService {
    //��ʾ���е���Ʒ
    List<Product> showAllProducts();
    //�����Ʒ
    boolean addProduct(String productName, String productPrice, String productType);
    //�����Ʒ����һ��id
    int addProductBackId(String productName, String productPrice, String productType);
    //��ʾ���е���Ʒ
    List<Product> listProduct();
    //������Ʒ��Ϣ
    boolean updateProduct(Integer id,String productName, String productPrice, String productType);
    //ͨ����Ʒid���Ҷ�Ӧ����Ʒ
    Product findProductById(Integer productId);
}
