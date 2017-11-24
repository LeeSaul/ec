package com.ls.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class Address implements Serializable {
  public static final String ADDRESS_DEFAULT="DEFAULT";
  public static final String ADDRESS_OTHER="OTHER";
  private Integer id;
  private Integer customerId;
  private String province;
  private String city;
  private String county;
  private String road;
  private Timestamp addressCreateTime;
  private String addressStatus;
  private String addressPhone;
  private String addressReceiver;

  public Address() {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
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

  public Timestamp getAddressCreateTime() {
    return addressCreateTime;
  }

  public void setAddressCreateTime(Timestamp addressCreateTime) {
    this.addressCreateTime = addressCreateTime;
  }

  public String getAddressStatus() {
    return addressStatus;
  }

  public void setAddressStatus(String addressStatus) {
    this.addressStatus = addressStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Address address = (Address) o;

    if (id != null ? !id.equals(address.id) : address.id != null) return false;
    if (customerId != null ? !customerId.equals(address.customerId) : address.customerId != null) return false;
    if (province != null ? !province.equals(address.province) : address.province != null) return false;
    if (city != null ? !city.equals(address.city) : address.city != null) return false;
    if (county != null ? !county.equals(address.county) : address.county != null) return false;
    if (road != null ? !road.equals(address.road) : address.road != null) return false;
    if (addressCreateTime != null ? !addressCreateTime.equals(address.addressCreateTime) : address.addressCreateTime != null)
      return false;
    if (addressStatus != null ? !addressStatus.equals(address.addressStatus) : address.addressStatus != null)
      return false;
    if (addressPhone != null ? !addressPhone.equals(address.addressPhone) : address.addressPhone != null) return false;
    return addressReceiver != null ? addressReceiver.equals(address.addressReceiver) : address.addressReceiver == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
    result = 31 * result + (province != null ? province.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (county != null ? county.hashCode() : 0);
    result = 31 * result + (road != null ? road.hashCode() : 0);
    result = 31 * result + (addressCreateTime != null ? addressCreateTime.hashCode() : 0);
    result = 31 * result + (addressStatus != null ? addressStatus.hashCode() : 0);
    result = 31 * result + (addressPhone != null ? addressPhone.hashCode() : 0);
    result = 31 * result + (addressReceiver != null ? addressReceiver.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Address{" +
            "id=" + id +
            ", customerId=" + customerId +
            ", province='" + province + '\'' +
            ", city='" + city + '\'' +
            ", county='" + county + '\'' +
            ", road='" + road + '\'' +
            ", addressCreateTime=" + addressCreateTime +
            ", addressStatus='" + addressStatus + '\'' +
            ", addressPhone='" + addressPhone + '\'' +
            ", addressReceiver='" + addressReceiver + '\'' +
            '}';
  }
}
