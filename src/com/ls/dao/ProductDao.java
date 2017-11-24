package com.ls.dao;

import com.ls.entity.Product;

import java.util.List;

/**
 * Created by LS on 2017/9/12 7:28.
 * To Be or Not to Be
 */
public interface ProductDao {
    //显示所有的商品
    List<Product> findAllProducts();
    //添加商品
    boolean addProduct(Product product);
    //添加商品返回一个这个对应的id
    int addProductBackId(Product product);
    //显示所有商品信息
    List<Product> listProduct();
    //更新商品信息
    boolean updateProduct(Product product);
    //通过商品id查找对应的商品
    Product findProductById(Integer productId);
}
