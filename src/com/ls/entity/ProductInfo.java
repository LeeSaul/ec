package com.ls.entity;

import java.io.Serializable;

/**
 * Created by LS on 2017/9/12 19:48.
 * To Be or Not to Be
 */
public class ProductInfo implements Serializable {
    private Product product;
    private  ProductDetail productDetail;

    public ProductInfo() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfo that = (ProductInfo) o;

        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return productDetail != null ? productDetail.equals(that.productDetail) : that.productDetail == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (productDetail != null ? productDetail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "product=" + product +
                ", productDetail=" + productDetail +
                '}';
    }
}
