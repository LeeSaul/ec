package com.ls.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class Shopcart implements Serializable {

  private Integer id;
  private Integer customerId;
  private Integer productId;
  private Integer productCartCount;
  private Timestamp createCartTime;

  public Shopcart() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getProductCartCount() {
    return productCartCount;
  }

  public void setProductCartCount(Integer productCartCount) {
    this.productCartCount = productCartCount;
  }

  public Timestamp getCreateCartTime() {
    return createCartTime;
  }

  public void setCreateCartTime(Timestamp createCartTime) {
    this.createCartTime = createCartTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Shopcart shopcart = (Shopcart) o;

    if (id != null ? !id.equals(shopcart.id) : shopcart.id != null) return false;
    if (customerId != null ? !customerId.equals(shopcart.customerId) : shopcart.customerId != null) return false;
    if (productId != null ? !productId.equals(shopcart.productId) : shopcart.productId != null) return false;
    if (productCartCount != null ? !productCartCount.equals(shopcart.productCartCount) : shopcart.productCartCount != null)
      return false;
    return createCartTime != null ? createCartTime.equals(shopcart.createCartTime) : shopcart.createCartTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (productCartCount != null ? productCartCount.hashCode() : 0);
    result = 31 * result + (createCartTime != null ? createCartTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Shopcart{" +
            "id=" + id +
            ", customerId=" + customerId +
            ", productId=" + productId +
            ", productCartCount=" + productCartCount +
            ", createCartTime=" + createCartTime +
            '}';
  }
}
