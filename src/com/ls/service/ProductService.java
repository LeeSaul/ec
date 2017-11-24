package com.ls.service;

import com.ls.entity.Product;

import java.util.List;

/**
 * Created by LS on 2017/9/12 7:32.
 * To Be or Not to Be
 */
public interface ProductService {
    //显示所有的商品
    List<Product> showAllProducts();
    //添加商品
    boolean addProduct(String productName, String productPrice, String productType);
    //添加商品返回一个id
    int addProductBackId(String productName, String productPrice, String productType);
    //显示所有的商品
    List<Product> listProduct();
    //更新商品信息
    boolean updateProduct(Integer id,String productName, String productPrice, String productType);
    //通过商品id查找对应的商品
    Product findProductById(Integer productId);
}
