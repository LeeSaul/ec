package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/9/20 7:37.
 * To Be or Not to Be
 */
public class OrderListInfo implements Serializable{
    //Product
    private String productName;
    private BigDecimal productPrice;
    //ProductDetail
    private String smallImage;
    //OrderList
    private Integer customerId;
    private Integer addressId;
    private BigDecimal totalMoney;
    private String orderStatus;
    private Timestamp orderCreateTime;
    //OrderItem
    private Integer orderListId;
    private Integer orderItemId;
    private Integer productId;
    private Integer productCount;
    private String itemOrderStatus;
    //Address
    private String province;
    private String city;
    private String county;
    private String road;
    private String addressPhone;
    private String addressReceiver;

    public OrderListInfo() {
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver;
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

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
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

        OrderListInfo that = (OrderListInfo) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (smallImage != null ? !smallImage.equals(that.smallImage) : that.smallImage != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (totalMoney != null ? !totalMoney.equals(that.totalMoney) : that.totalMoney != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (orderCreateTime != null ? !orderCreateTime.equals(that.orderCreateTime) : that.orderCreateTime != null)
            return false;
        if (orderListId != null ? !orderListId.equals(that.orderListId) : that.orderListId != null) return false;
        if (orderItemId != null ? !orderItemId.equals(that.orderItemId) : that.orderItemId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productCount != null ? !productCount.equals(that.productCount) : that.productCount != null) return false;
        if (itemOrderStatus != null ? !itemOrderStatus.equals(that.itemOrderStatus) : that.itemOrderStatus != null)
            return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (road != null ? !road.equals(that.road) : that.road != null) return false;
        if (addressPhone != null ? !addressPhone.equals(that.addressPhone) : that.addressPhone != null) return false;
        return addressReceiver != null ? addressReceiver.equals(that.addressReceiver) : that.addressReceiver == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (smallImage != null ? smallImage.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (totalMoney != null ? totalMoney.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderCreateTime != null ? orderCreateTime.hashCode() : 0);
        result = 31 * result + (orderListId != null ? orderListId.hashCode() : 0);
        result = 31 * result + (orderItemId != null ? orderItemId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productCount != null ? productCount.hashCode() : 0);
        result = 31 * result + (itemOrderStatus != null ? itemOrderStatus.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (road != null ? road.hashCode() : 0);
        result = 31 * result + (addressPhone != null ? addressPhone.hashCode() : 0);
        result = 31 * result + (addressReceiver != null ? addressReceiver.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderListInfo{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", smallImage='" + smallImage + '\'' +
                ", customerId=" + customerId +
                ", addressId=" + addressId +
                ", totalMoney=" + totalMoney +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCreateTime=" + orderCreateTime +
                ", orderListId=" + orderListId +
                ", orderItemId=" + orderItemId +
                ", productId=" + productId +
                ", productCount=" + productCount +
                ", itemOrderStatus='" + itemOrderStatus + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", road='" + road + '\'' +
                ", addressPhone='" + addressPhone + '\'' +
                ", addressReceiver='" + addressReceiver + '\'' +
                '}';
    }
}
