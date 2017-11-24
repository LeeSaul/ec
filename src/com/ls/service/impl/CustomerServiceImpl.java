package com.ls.service.impl;

import com.ls.dao.CustomerDao;
import com.ls.dao.impl.CustomerDaoImpl;
import com.ls.entity.Customer;
import com.ls.service.CustomerService;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/13 16:08.
 * To Be or Not to Be
 */
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;

    public CustomerServiceImpl() {
        customerDao=new CustomerDaoImpl();
    }

    @Override
    public boolean customerRegister(String customerName, String customerPassword) {
        return customerDao.customerRegister(customerName,customerPassword);
    }

    @Override
    public int customerRegisterBackId(String customerName, String customerPassword) {
        return customerDao.customerRegisterBackId(customerName,customerPassword);
    }


    @Override
    public Customer customerLogin(String customerName, String customerPassword) {
        return customerDao.customerLogin(customerName,customerPassword);
    }

    @Override
    public Customer findCustomerByName(String customerName) {
        return customerDao.findCustomerByName(customerName);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public boolean updateMoneyById(int id, BigDecimal money) {
        return customerDao.updateMoneyById(id,money);
    }
}
