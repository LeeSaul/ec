package com.ls.service.impl;

import com.ls.dao.ProductDao;
import com.ls.dao.impl.ProductDaoImpl;
import com.ls.entity.Product;
import com.ls.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/9/12 7:32.
 * To Be or Not to Be
 */
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    public ProductServiceImpl() {
        productDao=new ProductDaoImpl();
    }

    @Override
    public List<Product> showAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public boolean addProduct(String productName, String productPrice, String productType) {
        Product product=new Product();
        product.setProductName(productName);
        product.setProductPrice(new BigDecimal(productPrice));
        product.setProductType(productType);
        return productDao.addProduct(product);
    }

    @Override
    public int addProductBackId(String productName, String productPrice, String productType) {
        Product product=new Product();
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductPrice(new BigDecimal(productPrice));

        return productDao.addProductBackId(product);
    }

    @Override
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Override
    public boolean updateProduct(Integer id,String productName, String productPrice, String productType) {
        Product product=new Product();
        product.setId(id);
        product.setProductName(productName);
        product.setProductPrice(new BigDecimal(productPrice));
        product.setProductType(productType);
        return productDao.updateProduct(product);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productDao.findProductById(productId);
    }
}
