package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/17 7:33.
 * To Be or Not to Be
 */
public class ShelfProductInfos implements Serializable{
    //Product
    private Integer pId;
    private String productName;
    private BigDecimal productPrice;
    private String productType;
    //ProductDetail
    private String smallImage;
    private String bigImage;
    private String productCaption;
//    Shelf
    private String shelfStatus;
    //Stock
    private Integer stockNumber;

    public ShelfProductInfos() {
    }

    public String getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(String shelfStatus) {
        this.shelfStatus = shelfStatus;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getProductCaption() {
        return productCaption;
    }

    public void setProductCaption(String productCaption) {
        this.productCaption = productCaption;
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

        ShelfProductInfos that = (ShelfProductInfos) o;

        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (smallImage != null ? !smallImage.equals(that.smallImage) : that.smallImage != null) return false;
        if (bigImage != null ? !bigImage.equals(that.bigImage) : that.bigImage != null) return false;
        if (productCaption != null ? !productCaption.equals(that.productCaption) : that.productCaption != null)
            return false;
        if (shelfStatus != null ? !shelfStatus.equals(that.shelfStatus) : that.shelfStatus != null) return false;
        return stockNumber != null ? stockNumber.equals(that.stockNumber) : that.stockNumber == null;
    }

    @Override
    public int hashCode() {
        int result = pId != null ? pId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (smallImage != null ? smallImage.hashCode() : 0);
        result = 31 * result + (bigImage != null ? bigImage.hashCode() : 0);
        result = 31 * result + (productCaption != null ? productCaption.hashCode() : 0);
        result = 31 * result + (shelfStatus != null ? shelfStatus.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShelfProductInfos{" +
                "pId=" + pId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                ", smallImage='" + smallImage + '\'' +
                ", bigImage='" + bigImage + '\'' +
                ", productCaption='" + productCaption + '\'' +
                ", shelfStatus='" + shelfStatus + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
