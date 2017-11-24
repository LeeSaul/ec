package com.ls.dao.impl;

import com.ls.dao.ProductDao;
import com.ls.entity.Product;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/12 7:28.
 * To Be or Not to Be
 */
public class ProductDaoImpl extends BaseDao implements ProductDao{
    @Override
    public List<Product> findAllProducts() {
        String sql="select * from product";
        List<Object> params=null;
        List<Product> products = query(sql, params, Product.class);
        if (products!=null){
            return products;
        }
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        int i = addProductBackId(product);
        if (i==-1){
            return false;
        }
        return true;
    }

    @Override
    public int addProductBackId(Product product) {
        String sql="insert into product(product_name,product_price,product_type,product_create_time)values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(product.getProductName());
        params.add(product.getProductPrice());
        params.add(product.getProductType());
        params.add(new Timestamp(new Date().getTime()));
        List<Integer> ids = updateBackIdList(sql, params);
        if (ids.size()>0){
            return ids.get(0);
        }
        return -1;
    }

    @Override
    public List<Product> listProduct() {
        String sql="select * from product";
        List<Product> productList = query(sql, null, Product.class);
        return productList;
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql="update product set product_name=?,product_price=?,product_type=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(product.getProductName());
        params.add(product.getProductPrice());
        params.add(product.getProductType());
        params.add(product.getId());
        return update(sql, params);
    }

    @Override
    public Product findProductById(Integer productId) {
        String sql="select * from product where id=?";
        List<Object> params=new ArrayList<>();
        params.add(productId);
        List<Product> query = query(sql, params, Product.class);
        if (query!=null){
            return query.get(0);
        }
        return  null;
    }
}
