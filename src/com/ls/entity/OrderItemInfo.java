package com.ls.entity;

import java.io.Serializable;

/**
 * Created by LS on 2017/9/25 16:14.
 * To Be or Not to Be
 */
public class OrderItemInfo implements Serializable{
    //OrderItem
    private Integer orderListId;
    private Integer productId;
    private Integer productCount;

    //Shelf
    private String shelfStatus;
    //Stock
    private Integer stockNumber;

    public OrderItemInfo() {
    }

    public Integer getOrderListId() {
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

    public String getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(String shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemInfo that = (OrderItemInfo) o;

        if (orderListId != null ? !orderListId.equals(that.orderListId) : that.orderListId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productCount != null ? !productCount.equals(that.productCount) : that.productCount != null) return false;
        if (shelfStatus != null ? !shelfStatus.equals(that.shelfStatus) : that.shelfStatus != null) return false;
        return stockNumber != null ? stockNumber.equals(that.stockNumber) : that.stockNumber == null;
    }

    @Override
    public int hashCode() {
        int result = orderListId != null ? orderListId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productCount != null ? productCount.hashCode() : 0);
        result = 31 * result + (shelfStatus != null ? shelfStatus.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItemInfo{" +
                "orderListId=" + orderListId +
                ", productId=" + productId +
                ", productCount=" + productCount +
                ", shelfStatus='" + shelfStatus + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
