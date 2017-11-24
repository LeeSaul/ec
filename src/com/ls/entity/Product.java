package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
public class Product implements Serializable {

  private Integer id;
  private String productName;
  private BigDecimal productPrice;
  private String productType;
  private Timestamp productCreateTime;

  public Product() {
  }

  public Product(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(BigDecimal productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public Timestamp getProductCreateTime() {
    return productCreateTime;
  }

  public void setProductCreateTime(Timestamp productCreateTime) {
    this.productCreateTime = productCreateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    if (id != null ? !id.equals(product.id) : product.id != null) return false;
    if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
    if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null) return false;
    if (productType != null ? !productType.equals(product.productType) : product.productType != null) return false;
    return productCreateTime != null ? productCreateTime.equals(product.productCreateTime) : product.productCreateTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productName != null ? productName.hashCode() : 0);
    result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
    result = 31 * result + (productType != null ? productType.hashCode() : 0);
    result = 31 * result + (productCreateTime != null ? productCreateTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", productName='" + productName + '\'' +
            ", productPrice=" + productPrice +
            ", productType='" + productType + '\'' +
            ", productCreateTime=" + productCreateTime +
            '}';
  }
}
