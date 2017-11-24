package com.ls.dao;

import com.ls.entity.Product;

import java.util.List;

/**
 * Created by LS on 2017/9/12 7:28.
 * To Be or Not to Be
 */
public interface ProductDao {
    //��ʾ���е���Ʒ
    List<Product> findAllProducts();
    //�����Ʒ
    boolean addProduct(Product product);
    //�����Ʒ����һ�������Ӧ��id
    int addProductBackId(Product product);
    //��ʾ������Ʒ��Ϣ
    List<Product> listProduct();
    //������Ʒ��Ϣ
    boolean updateProduct(Product product);
    //ͨ����Ʒid���Ҷ�Ӧ����Ʒ
    Product findProductById(Integer productId);
}
