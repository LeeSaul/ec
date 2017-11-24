package com.ls.service;

import com.ls.entity.Customer;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/13 16:08.
 * To Be or Not to Be
 */
public interface CustomerService {
    //ע���û�
    boolean customerRegister(String customerName,String customerPassword);
    //ע���û������û�id
    int customerRegisterBackId(String customerName,String customerPassword);
    //��¼
    Customer customerLogin(String customerName, String customerPassword);
    //ͨ���û������Ҹù˿���Ϣ
    Customer findCustomerByName(String customerName);
    //ͨ���û�id���ҹ˿���Ϣ
    Customer findCustomerById(int id);
    boolean updateMoneyById(int id, BigDecimal money);
}
