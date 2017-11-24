package com.ls.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class OrderItem implements Serializable {
  public static final String ITEM_SHIPPED="SHIPPED";
  public static final String ITEM_NOT_SHIPPED="NOT_SHIPPED";
  private Integer id;
  private Integer orderListId;
  private Integer productId;
  private Integer productCount;
  private Timestamp itemCreateTime;
  private String itemOrderStatus;

  public OrderItem() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public long getOrderListId() {
    return orderListId;
  }

  public void setOrderListId(Integer orderListId) {
    this.orderListId = orderListId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getProductCount() {
    return productCount;
  }

  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }

  public Timestamp getItemCreateTime() {
    return itemCreateTime;
  }

  public void setItemCreateTime(Timestamp itemCreateTime) {
    this.itemCreateTime = itemCreateTime;
  }

  public String getItemOrderStatus() {
    return itemOrderStatus;
  }

  public void setItemOrderStatus(String itemOrderStatus) {
    this.itemOrderStatus = itemOrderStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OrderItem orderItem = (OrderItem) o;

    if (orderListId != orderItem.orderListId) return false;
    if (productId != orderItem.productId) return false;
    if (productCount != orderItem.productCount) return false;
    if (id != null ? !id.equals(orderItem.id) : orderItem.id != null) return false;
    if (itemCreateTime != null ? !itemCreateTime.equals(orderItem.itemCreateTime) : orderItem.itemCreateTime != null)
      return false;
    return itemOrderStatus != null ? itemOrderStatus.equals(orderItem.itemOrderStatus) : orderItem.itemOrderStatus == null;
  }



  @Override
  public String toString() {
    return "OrderItem{" +
            "id=" + id +
            ", orderListId=" + orderListId +
            ", productId=" + productId +
            ", productCount=" + productCount +
            ", itemCreateTime=" + itemCreateTime +
            ", itemOrderStatus='" + itemOrderStatus + '\'' +
            '}';
  }
}
