package com.ls.entity;

import java.io.Serializable;

public class ProductDetail implements Serializable {

  private Integer id;
  private Integer productId;
  private String smallImage;
  private String bigImage;
  private String productCaption;

  public ProductDetail() {
  }

  public ProductDetail(String bigImage) {
    this.bigImage = bigImage;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getSmallImage() {
    return smallImage;
  }

  public void setSmallImage(String smallImage) {
    this.smallImage = smallImage;
  }

  public String getBigImage() {
    return bigImage;
  }

  public void setBigImage(String bigImage) {
    this.bigImage = bigImage;
  }

  public String getProductCaption() {
    return productCaption;
  }

  public void setProductCaption(String productCaption) {
    this.productCaption = productCaption;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ProductDetail that = (ProductDetail) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
    if (smallImage != null ? !smallImage.equals(that.smallImage) : that.smallImage != null) return false;
    if (bigImage != null ? !bigImage.equals(that.bigImage) : that.bigImage != null) return false;
    return productCaption != null ? productCaption.equals(that.productCaption) : that.productCaption == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (smallImage != null ? smallImage.hashCode() : 0);
    result = 31 * result + (bigImage != null ? bigImage.hashCode() : 0);
    result = 31 * result + (productCaption != null ? productCaption.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProductDetail{" +
            "id=" + id +
            ", productId=" + productId +
            ", smallImage='" + smallImage + '\'' +
            ", bigImage='" + bigImage + '\'' +
            ", productCaption='" + productCaption + '\'' +
            '}';
  }
}
