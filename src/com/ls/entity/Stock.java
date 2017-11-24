package com.ls.entity;


import java.io.Serializable;
import java.sql.Timestamp;
public class Stock implements Serializable {

  private Integer id;
  private Integer productId;
  private Integer adminId;
  private Integer stockNumber;
  private Timestamp stockUpdateTime;

  public Stock() {
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

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public Integer getStockNumber() {
    return stockNumber;
  }

  public void setStockNumber(Integer stockNumber) {
    this.stockNumber = stockNumber;
  }

  public Timestamp getStockUpdateTime() {
    return stockUpdateTime;
  }

  public void setStockUpdateTime(Timestamp stockUpdateTime) {
    this.stockUpdateTime = stockUpdateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Stock stock = (Stock) o;

    if (id != null ? !id.equals(stock.id) : stock.id != null) return false;
    if (productId != null ? !productId.equals(stock.productId) : stock.productId != null) return false;
    if (adminId != null ? !adminId.equals(stock.adminId) : stock.adminId != null) return false;
    if (stockNumber != null ? !stockNumber.equals(stock.stockNumber) : stock.stockNumber != null) return false;
    return stockUpdateTime != null ? stockUpdateTime.equals(stock.stockUpdateTime) : stock.stockUpdateTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
    result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
    result = 31 * result + (stockUpdateTime != null ? stockUpdateTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Stock{" +
            "id=" + id +
            ", productId=" + productId +
            ", adminId=" + adminId +
            ", stockNumber=" + stockNumber +
            ", stockUpdateTime=" + stockUpdateTime +
            '}';
  }
}
