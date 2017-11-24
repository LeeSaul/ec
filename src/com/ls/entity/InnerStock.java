package com.ls.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InnerStock implements Serializable {

  private Integer id;
  private Integer productId;
  private Integer adminId;
  private Integer innerStockNumber;
  private Timestamp innerTime;
  private BigDecimal innerUnitPrice;


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

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public Integer getInnerStockNumber() {
    return innerStockNumber;
  }

  public void setInnerStockNumber(Integer innerStockNumber) {
    this.innerStockNumber = innerStockNumber;
  }

  public Timestamp getInnerTime() {
    return innerTime;
  }

  public void setInnerTime(Timestamp innerTime) {
    this.innerTime = innerTime;
  }

  public BigDecimal getInnerUnitPrice() {
    return innerUnitPrice;
  }

  public void setInnerUnitPrice(BigDecimal innerUnitPrice) {
    this.innerUnitPrice = innerUnitPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    InnerStock that = (InnerStock) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
    if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
    if (innerStockNumber != null ? !innerStockNumber.equals(that.innerStockNumber) : that.innerStockNumber != null)
      return false;
    if (innerTime != null ? !innerTime.equals(that.innerTime) : that.innerTime != null) return false;
    return innerUnitPrice != null ? innerUnitPrice.equals(that.innerUnitPrice) : that.innerUnitPrice == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
    result = 31 * result + (innerStockNumber != null ? innerStockNumber.hashCode() : 0);
    result = 31 * result + (innerTime != null ? innerTime.hashCode() : 0);
    result = 31 * result + (innerUnitPrice != null ? innerUnitPrice.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "InnerStock{" +
            "id=" + id +
            ", productId=" + productId +
            ", adminId=" + adminId +
            ", innerStockNumber=" + innerStockNumber +
            ", innerTime=" + innerTime +
            ", innerUnitPrice=" + innerUnitPrice +
            '}';
  }
}
