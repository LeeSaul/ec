package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * Created by LS on 2017/9/25 18:44.
 * To Be or Not to Be
 */
public class OutStockInfo implements Serializable{
    //Admin
    private String name;
    //Produce
    private String productName;
    //OutStock
    private BigDecimal outUnitPrice;
    private Integer outStockNumber;
    private Timestamp outTime;
    private Integer adminId;

    public OutStockInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getOutUnitPrice() {
        return outUnitPrice;
    }

    public void setOutUnitPrice(BigDecimal outUnitPrice) {
        this.outUnitPrice = outUnitPrice;
    }

    public Integer getOutStockNumber() {
        return outStockNumber;
    }

    public void setOutStockNumber(Integer outStockNumber) {
        this.outStockNumber = outStockNumber;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutStockInfo that = (OutStockInfo) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (outUnitPrice != null ? !outUnitPrice.equals(that.outUnitPrice) : that.outUnitPrice != null) return false;
        if (outStockNumber != null ? !outStockNumber.equals(that.outStockNumber) : that.outStockNumber != null)
            return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        return adminId != null ? adminId.equals(that.adminId) : that.adminId == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (outUnitPrice != null ? outUnitPrice.hashCode() : 0);
        result = 31 * result + (outStockNumber != null ? outStockNumber.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OutStockInfoDao{" +
                "name='" + name + '\'' +
                ", productName='" + productName + '\'' +
                ", outUnitPrice=" + outUnitPrice +
                ", outStockNumber=" + outStockNumber +
                ", outTime=" + outTime +
                ", adminId=" + adminId +
                '}';
    }
}
