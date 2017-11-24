package com.ls.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Customer implements Serializable {
  public static final String CUSTOMER_NORMAL="NORMAL";

  private Integer id;
  private String customerName;
  private String customerPassword;
  private String customerPhone;
  private String customerEmail;
  private BigDecimal customerMoney;
  private Timestamp customerCreateTime;
  private Timestamp loginTime;
  private String customerStatus;

  public Customer() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerPassword() {
    return customerPassword;
  }

  public void setCustomerPassword(String customerPassword) {
    this.customerPassword = customerPassword;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public BigDecimal getCustomerMoney() {
    return customerMoney;
  }

  public void setCustomerMoney(BigDecimal customerMoney) {
    this.customerMoney = customerMoney;
  }

  public Timestamp getCustomerCreateTime() {
    return customerCreateTime;
  }

  public void setCustomerCreateTime(Timestamp customerCreateTime) {
    this.customerCreateTime = customerCreateTime;
  }

  public Timestamp getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Timestamp loginTime) {
    this.loginTime = loginTime;
  }

  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Customer customer = (Customer) o;

    if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
    if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
      return false;
    if (customerPassword != null ? !customerPassword.equals(customer.customerPassword) : customer.customerPassword != null)
      return false;
    if (customerPhone != null ? !customerPhone.equals(customer.customerPhone) : customer.customerPhone != null)
      return false;
    if (customerEmail != null ? !customerEmail.equals(customer.customerEmail) : customer.customerEmail != null)
      return false;
    if (customerMoney != null ? !customerMoney.equals(customer.customerMoney) : customer.customerMoney != null)
      return false;
    if (customerCreateTime != null ? !customerCreateTime.equals(customer.customerCreateTime) : customer.customerCreateTime != null)
      return false;
    if (loginTime != null ? !loginTime.equals(customer.loginTime) : customer.loginTime != null) return false;
    return customerStatus != null ? customerStatus.equals(customer.customerStatus) : customer.customerStatus == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
    result = 31 * result + (customerPassword != null ? customerPassword.hashCode() : 0);
    result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
    result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
    result = 31 * result + (customerMoney != null ? customerMoney.hashCode() : 0);
    result = 31 * result + (customerCreateTime != null ? customerCreateTime.hashCode() : 0);
    result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
    result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", customerName='" + customerName + '\'' +
            ", customerPassword='" + customerPassword + '\'' +
            ", customerPhone='" + customerPhone + '\'' +
            ", customerEmail='" + customerEmail + '\'' +
            ", customerMoney=" + customerMoney +
            ", customerCreateTime=" + customerCreateTime +
            ", loginTime=" + loginTime +
            ", customerStatus='" + customerStatus + '\'' +
            '}';
  }
}
