package com.ls.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class Shelf implements Serializable {
  public static final String SHELF_ON="已上架";
  public static final String SHELF_OFF="已下架";

  private Integer id;
  private Integer productId;
  private Integer adminId;
  private Timestamp shelfCreateTime;
  private String shelfStatus;

  public Shelf() {
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

  public Timestamp getShelfCreateTime() {
    return shelfCreateTime;
  }

  public void setShelfCreateTime(Timestamp shelfCreateTime) {
    this.shelfCreateTime = shelfCreateTime;
  }

  public String getShelfStatus() {
    return shelfStatus;
  }

  public void setShelfStatus(String shelfStatus) {
    this.shelfStatus = shelfStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Shelf shelf = (Shelf) o;

    if (id != null ? !id.equals(shelf.id) : shelf.id != null) return false;
    if (productId != null ? !productId.equals(shelf.productId) : shelf.productId != null) return false;
    if (adminId != null ? !adminId.equals(shelf.adminId) : shelf.adminId != null) return false;
    if (shelfCreateTime != null ? !shelfCreateTime.equals(shelf.shelfCreateTime) : shelf.shelfCreateTime != null)
      return false;
    return shelfStatus != null ? shelfStatus.equals(shelf.shelfStatus) : shelf.shelfStatus == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (productId != null ? productId.hashCode() : 0);
    result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
    result = 31 * result + (shelfCreateTime != null ? shelfCreateTime.hashCode() : 0);
    result = 31 * result + (shelfStatus != null ? shelfStatus.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Shelf{" +
            "id=" + id +
            ", productId=" + productId +
            ", adminId=" + adminId +
            ", shelfCreateTime=" + shelfCreateTime +
            ", shelfStatus='" + shelfStatus + '\'' +
            '}';
  }
}
