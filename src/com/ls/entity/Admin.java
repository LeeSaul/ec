package com.ls.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Admin implements Serializable {
  public  static final   String  ADMIN_STATE_NORMAL="NORMAL";
  private Integer id;
  private String adminName;
  private String adminPassword;
  private String adminState;
  private BigDecimal adminMoney;
  private Timestamp adminLastTime;

  public Admin() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  public String getAdminState() {
    return adminState;
  }

  public void setAdminState(String adminState) {
    this.adminState = adminState;
  }

  public BigDecimal getAdminMoney() {
    return adminMoney;
  }

  public void setAdminMoney(BigDecimal adminMoney) {
    this.adminMoney = adminMoney;
  }

  public Timestamp getAdminLastTime() {
    return adminLastTime;
  }

  public void setAdminLastTime(Timestamp adminLastTime) {
    this.adminLastTime = adminLastTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Admin admin = (Admin) o;

    if (id != null ? !id.equals(admin.id) : admin.id != null) return false;
    if (adminName != null ? !adminName.equals(admin.adminName) : admin.adminName != null) return false;
    if (adminPassword != null ? !adminPassword.equals(admin.adminPassword) : admin.adminPassword != null) return false;
    if (adminState != null ? !adminState.equals(admin.adminState) : admin.adminState != null) return false;
    if (adminMoney != null ? !adminMoney.equals(admin.adminMoney) : admin.adminMoney != null) return false;
    return adminLastTime != null ? adminLastTime.equals(admin.adminLastTime) : admin.adminLastTime == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
    result = 31 * result + (adminPassword != null ? adminPassword.hashCode() : 0);
    result = 31 * result + (adminState != null ? adminState.hashCode() : 0);
    result = 31 * result + (adminMoney != null ? adminMoney.hashCode() : 0);
    result = 31 * result + (adminLastTime != null ? adminLastTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", adminName='" + adminName + '\'' +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminState='" + adminState + '\'' +
            ", adminMoney=" + adminMoney +
            ", adminLastTime=" + adminLastTime +
            '}';
  }
}