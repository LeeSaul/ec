package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/9/14 22:56.
 * To Be or Not to Be
 */
public class ShelfInfo implements Serializable {
    //Admin
    private Integer aId;
    private String adminName;

    //Product
    private Integer pId;
    private String productName;
    private BigDecimal productPrice;

    //Stock
    private Integer stockProductId;
    private Integer stockNumber;

    //Shelf
    private Integer adminId;
    private Integer productId;
    private Timestamp shelfCreateTime;
    private String shelfStatus;

    public ShelfInfo() {
    }


    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public Integer getStockProductId() {
        return stockProductId;
    }

    public void setStockProductId(Integer stockProductId) {
        this.stockProductId = stockProductId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

        ShelfInfo shelfInfo = (ShelfInfo) o;

        if (aId != null ? !aId.equals(shelfInfo.aId) : shelfInfo.aId != null) return false;
        if (adminName != null ? !adminName.equals(shelfInfo.adminName) : shelfInfo.adminName != null) return false;
        if (pId != null ? !pId.equals(shelfInfo.pId) : shelfInfo.pId != null) return false;
        if (productName != null ? !productName.equals(shelfInfo.productName) : shelfInfo.productName != null)
            return false;
        if (productPrice != null ? !productPrice.equals(shelfInfo.productPrice) : shelfInfo.productPrice != null)
            return false;
        if (stockProductId != null ? !stockProductId.equals(shelfInfo.stockProductId) : shelfInfo.stockProductId != null)
            return false;
        if (stockNumber != null ? !stockNumber.equals(shelfInfo.stockNumber) : shelfInfo.stockNumber != null)
            return false;
        if (adminId != null ? !adminId.equals(shelfInfo.adminId) : shelfInfo.adminId != null) return false;
        if (productId != null ? !productId.equals(shelfInfo.productId) : shelfInfo.productId != null) return false;
        if (shelfCreateTime != null ? !shelfCreateTime.equals(shelfInfo.shelfCreateTime) : shelfInfo.shelfCreateTime != null)
            return false;
        return shelfStatus != null ? shelfStatus.equals(shelfInfo.shelfStatus) : shelfInfo.shelfStatus == null;
    }

    @Override
    public int hashCode() {
        int result = aId != null ? aId.hashCode() : 0;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (stockProductId != null ? stockProductId.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (shelfCreateTime != null ? shelfCreateTime.hashCode() : 0);
        result = 31 * result + (shelfStatus != null ? shelfStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShelfInfo{" +
                "aId=" + aId +
                ", adminName='" + adminName + '\'' +
                ", pId=" + pId +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", stockProductId=" + stockProductId +
                ", stockNumber=" + stockNumber +
                ", adminId=" + adminId +
                ", productId=" + productId +
                ", shelfCreateTime=" + shelfCreateTime +
                ", shelfStatus='" + shelfStatus + '\'' +
                '}';
    }
}
