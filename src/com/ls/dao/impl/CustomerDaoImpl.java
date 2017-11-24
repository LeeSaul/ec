package com.ls.dao.impl;

import com.ls.dao.CustomerDao;
import com.ls.entity.Customer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/13 15:58.
 * To Be or Not to Be
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao{
    @Override
    public boolean customerRegister(String customerName,String customerPassword) {
        String  sql="insert into customer(customer_name,customer_password,customer_create_time,customer_status) values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(customerName);
        params.add(customerPassword);
        params.add(new Timestamp(new Date().getTime()));
        params.add(Customer.CUSTOMER_NORMAL);
        return update(sql,params);
    }

    @Override
    public int customerRegisterBackId(String customerName, String customerPassword) {
        String  sql="insert into customer(customer_name,customer_password,customer_create_time,customer_status) values(?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(customerName);
        params.add(customerPassword);
        params.add(new Timestamp(new Date().getTime()));
        params.add(Customer.CUSTOMER_NORMAL);
        List<Integer> list = updateBackIdList(sql, params);
        if (list!=null){
            return list.get(0);
        }
        return 0;
    }

    @Override
    public Customer customerLogin(String customerName,String customerPassword) {
        String  sql="select * from customer where customer_name=? AND customer_password=?";
        List<Object> params=new ArrayList<>();
        params.add(customerName);
        params.add(customerPassword);
        List<Customer> query = query(sql, params, Customer.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public Customer findCustomerByName(String customerName) {
        String  sql="select * from customer where customer_name=?";
        List<Object> params=new ArrayList<>();
        params.add(customerName);
        List<Customer> query = query(sql, params, Customer.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public Customer findCustomerById(int id) {
        String  sql="select * from customer where id=?";
        List<Object> params=new ArrayList<>();
        params.add(id);
        List<Customer> query = query(sql, params, Customer.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public boolean updateMoneyById(int id, BigDecimal money) {
        String sql="update customer set customer_money=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(money);
        params.add(id);
        return update(sql,params);
    }
}
