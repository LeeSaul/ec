package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/9/14 8:38.
 * To Be or Not to Be
 */
public class InnerStockInfo implements Serializable {
    //Admin
    private Integer aId;
    private String adminName;
    //Product
    private Integer pId;
    private String productName;
    private BigDecimal productPrice;
    //InnerStock
    private Integer adminId;
    private Integer productId;
    private Integer innerStockNumber;
    private Timestamp innerTime;
    private BigDecimal innerUnitPrice;

    public InnerStockInfo() {
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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

    public Integer getInnerStockNumber() {
        return innerStockNumber;
    }

    public void setInnerStockNumber(Integer innerStockNumber) {
        this.innerStockNumber = innerStockNumber;
    }

    public Timestamp getInnerTime() {
        return innerTime;
    }

    public void setInnerTime(Timestamp innerTime) {
        this.innerTime = innerTime;
    }

    public BigDecimal getInnerUnitPrice() {
        return innerUnitPrice;
    }

    public void setInnerUnitPrice(BigDecimal innerUnitPrice) {
        this.innerUnitPrice = innerUnitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InnerStockInfo that = (InnerStockInfo) o;

        if (aId != null ? !aId.equals(that.aId) : that.aId != null) return false;
        if (adminName != null ? !adminName.equals(that.adminName) : that.adminName != null) return false;
        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (innerStockNumber != null ? !innerStockNumber.equals(that.innerStockNumber) : that.innerStockNumber != null)
            return false;
        if (innerTime != null ? !innerTime.equals(that.innerTime) : that.innerTime != null) return false;
        return innerUnitPrice != null ? innerUnitPrice.equals(that.innerUnitPrice) : that.innerUnitPrice == null;
    }

    @Override
    public int hashCode() {
        int result = aId != null ? aId.hashCode() : 0;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (innerStockNumber != null ? innerStockNumber.hashCode() : 0);
        result = 31 * result + (innerTime != null ? innerTime.hashCode() : 0);
        result = 31 * result + (innerUnitPrice != null ? innerUnitPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InnerStockInfo{" +
                "aId=" + aId +
                ", adminName='" + adminName + '\'' +
                ", pId=" + pId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", adminId=" + adminId +
                ", productId=" + productId +
                ", innerStockNumber=" + innerStockNumber +
                ", innerTime=" + innerTime +
                ", innerUnitPrice=" + innerUnitPrice +
                '}';
    }
}
