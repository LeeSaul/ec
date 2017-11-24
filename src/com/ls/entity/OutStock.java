package com.ls.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OutStock implements Serializable {

  private Integer id;
  private Integer productId;
  private Integer adminId;
  private Integer outStockNumber;
  private Timestamp out_Time;
  private BigDecimal outUnitPrice;

  public OutStock() {
  }

  public BigDecimal getOutUnitPrice() {
    return outUnitPrice;
  }

  public void setOutUnitPrice(BigDecimal outUnitPrice) {
    this.outUnitPrice = outUnitPrice;
  }

  public OutStock(Integer adminId) {
    this.adminId = adminId;
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

  public Integer getOutStockNumber() {
    return outStockNumber;
  }

  public void setOutStockNumber(Integer outStockNumber) {
    this.outStockNumber = outStockNumber;
  }

  public Timestamp getOut_Time() {
    return out_Time;
  }

  public void setOut_Time(Timestamp out_Time) {
    this.out_Time = out_Time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OutStock outStock = (OutStock) o;

    if (id != null ? !id.equals(outStock.id) : outStock.id != null) return false;
    if (productId != null ? !productId.equals(outStock.productId) : outStock.productId != null) return false;
    if (adminId != null ? !adminId.equals(outStock.adminId) : outStock.adminId != null) return false;
    if (outStockNumber != null ? !outStockNumber.equals(outStock.outStockNumber) : outStock.outStockNumber != null)
      return false;
    if (out_Time != null ? !out_Time.equals(outStock.out_Time) : outStock.out_Time != null) return false;
    return outUnitPrice != null ? outUnitPrice.equals(outStock.outUnitPrice) : outStock.outUnitPrice == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
    result = 31 * result + (outStockNumber != null ? outStockNumber.hashCode() : 0);
    result = 31 * result + (out_Time != null ? out_Time.hashCode() : 0);
    result = 31 * result + (outUnitPrice != null ? outUnitPrice.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OutStock{" +
            "id=" + id +
            ", productId=" + productId +
            ", adminId=" + adminId +
            ", outStockNumber=" + outStockNumber +
            ", out_Time=" + out_Time +
            ", outUnitPrice=" + outUnitPrice +
            '}';
  }
}
