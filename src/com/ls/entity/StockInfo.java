package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/9/13 18:32.
 * To Be or Not to Be
 */
public class StockInfo implements Serializable {
    //Product
    private Integer pId;
    private String productName;
    private BigDecimal productPrice;
    private String productType;
    //Stock
    private Integer stockId;
    private Integer productId;
    private Integer adminId;
    private Integer stockNumber;
    private Timestamp stockUpdateTime;

    public StockInfo() {
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

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
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

        StockInfo stockInfo = (StockInfo) o;

        if (pId != null ? !pId.equals(stockInfo.pId) : stockInfo.pId != null) return false;
        if (productName != null ? !productName.equals(stockInfo.productName) : stockInfo.productName != null)
            return false;
        if (productPrice != null ? !productPrice.equals(stockInfo.productPrice) : stockInfo.productPrice != null)
            return false;
        if (productType != null ? !productType.equals(stockInfo.productType) : stockInfo.productType != null)
            return false;
        if (stockId != null ? !stockId.equals(stockInfo.stockId) : stockInfo.stockId != null) return false;
        if (productId != null ? !productId.equals(stockInfo.productId) : stockInfo.productId != null) return false;
        if (adminId != null ? !adminId.equals(stockInfo.adminId) : stockInfo.adminId != null) return false;
        if (stockNumber != null ? !stockNumber.equals(stockInfo.stockNumber) : stockInfo.stockNumber != null)
            return false;
        return stockUpdateTime != null ? stockUpdateTime.equals(stockInfo.stockUpdateTime) : stockInfo.stockUpdateTime == null;
    }

    @Override
    public int hashCode() {
        int result = pId != null ? pId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (stockNumber != null ? stockNumber.hashCode() : 0);
        result = 31 * result + (stockUpdateTime != null ? stockUpdateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "pId=" + pId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                ", stockId=" + stockId +
                ", productId=" + productId +
                ", adminId=" + adminId +
                ", stockNumber=" + stockNumber +
                ", stockUpdateTime=" + stockUpdateTime +
                '}';
    }
}
