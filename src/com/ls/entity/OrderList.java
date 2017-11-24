package com.ls.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderList implements Serializable {
  public static final String NOT_SEND="NOT_SEND";
  public static final String NOT_CONFIRMED="NOT_CONFIRMED";
  public static final String CONFIRMED="CONFIRMED";

  private Integer id;
  private Integer customerId;
  private Integer addressId;
  private BigDecimal totalMoney;
  private String orderStatus;
  private Timestamp orderCreateTime;

  public OrderList() {
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

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public BigDecimal getTotalMoney() {
    return totalMoney;
  }

  public void setTotalMoney(BigDecimal totalMoney) {
    this.totalMoney = totalMoney;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Timestamp getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(Timestamp orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OrderList orderList = (OrderList) o;

    if (id != null ? !id.equals(orderList.id) : orderList.id != null) return false;
    if (customerId != null ? !customerId.equals(orderList.customerId) : orderList.customerId != null) return false;
    if (addressId != null ? !addressId.equals(orderList.addressId) : orderList.addressId != null) return false;
    if (totalMoney != null ? !totalMoney.equals(orderList.totalMoney) : orderList.totalMoney != null) return false;
    if (orderStatus != null ? !orderStatus.equals(orderList.orderStatus) : orderList.orderStatus != null) return false;
    return orderCreateTime != null ? orderCreateTime.equals(orderList.orderCreateTime) : orderList.orderCreateTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
    result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
    result = 31 * result + (totalMoney != null ? totalMoney.hashCode() : 0);
    result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
    result = 31 * result + (orderCreateTime != null ? orderCreateTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OrderList{" +
            "id=" + id +
            ", customerId=" + customerId +
            ", addressId=" + addressId +
            ", totalMoney=" + totalMoney +
            ", orderStatus='" + orderStatus + '\'' +
            ", orderCreateTime=" + orderCreateTime +
            '}';
  }
}
