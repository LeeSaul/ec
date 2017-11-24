package com.ls.dao;

import com.ls.entity.Customer;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/13 15:58.
 * To Be or Not to Be
 */
public interface CustomerDao {
    //注册用户
    boolean customerRegister(String customerName,String customerPassword);
    //注册用户返回用户id
    int customerRegisterBackId(String customerName,String customerPassword);
    //登录顾客账户
    Customer customerLogin(String customerName,String customerPassword);
    //通过用户名查找该顾客信息
    Customer findCustomerByName(String customerName);
    //通过用户id查找顾客信息
    Customer findCustomerById(int id);
    //通过id更改顾客的money
    boolean updateMoneyById(int id, BigDecimal money);
}
