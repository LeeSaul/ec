package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/17 13:28.
 * To Be or Not to Be
 */
public class ShopcartInfo  implements Serializable {
    //Product
    private Integer pId;
    private String productName;
    private BigDecimal productPrice;
    //ProductDetail
    private String smallImage;
    //Shopcart
    private Integer shopcartId;
    private Integer productCartCount;
    private Integer customerId;

    //    Shelf
    private String shelfStatus;
    private Integer stockNumber;
    public ShopcartInfo() {
    }

    public Integer getShopcartId() {
        return shopcartId;
    }

    public void setShopcartId(Integer shopcartId) {
        this.shopcartId = shopcartId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(String shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    public Integer getProductCartCount() {
        return productCartCount;
    }

    public void setProductCartCount(Integer productCartCount) {
        this.productCartCount = productCartCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopcartInfo that = (ShopcartInfo) o;

        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (smallImage != null ? !smallImage.equals(that.smallImage) : that.smallImage != null) return false;
        if (shopcartId != null ? !shopcartId.equals(that.shopcartId) : that.shopcartId != null) return false;
        if (productCartCount != null ? !productCartCount.equals(that.productCartCount) : that.productCartCount != null)
            return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (shelfStatus != null ? !shelfStatus.equals(that.shelfStatus) : that.shelfStatus != null) return false;
        return stockNumber != null ? stockNumber.equals(that.stockNumber) : that.stockNumber == null;
    }

    @Override
    public int hashCode() {
        int result = pId != null ? pId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (smallImage != null ? smallImage.hashCode() : 0);
        result = 31 * result + (shopcartId != null ? shopcartId.hashCode() : 0);
        result = 31 * result + (productCartCount != null ? productCartCount.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (shelfStatus != null ? shelfStatus.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopcartInfo{" +
                "pId=" + pId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", smallImage='" + smallImage + '\'' +
                ", shopcartId=" + shopcartId +
                ", productCartCount=" + productCartCount +
                ", customerId=" + customerId +
                ", shelfStatus='" + shelfStatus + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
