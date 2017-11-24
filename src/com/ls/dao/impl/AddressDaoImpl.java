package com.ls.dao.impl;

import com.ls.dao.AddressDao;
import com.ls.entity.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/9/18 14:31.
 * To Be or Not to Be
 */
public class AddressDaoImpl extends BaseDao implements AddressDao{
    @Override
    public Integer addAddressBackId(Address address) {
        String sql="insert into address(customer_id,province,city,county,road,address_status,address_phone,address_receiver) values(?,?,?,?,?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(address.getCustomerId());
        params.add(address.getProvince());
        params.add(address.getCity());
        params.add(address.getCounty());
        params.add(address.getRoad());
        params.add(address.getAddressStatus());
        params.add(address.getAddressPhone());
        params.add(address.getAddressReceiver());
        List<Integer> list = updateBackIdList(sql, params);
        if (list!=null){
            return list.get(0);
        }
        return 0;
    }

    @Override
    public List<Address> findAddressByCustomerId(Integer customerId) {
        String sql="select * from address where customer_id=?";
        List<Object> params=new ArrayList<>();
        params.add(customerId);
        List<Address> query = query(sql, params, Address.class);
        return query;
    }

    @Override
    public Address findAddressByAddressId(Integer addressId) {
        String sql="select * from address where id=?";
        List<Object> params=new ArrayList<>();
        params.add(addressId);
        List<Address> query = query(sql, params, Address.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }

    @Override
    public boolean updateAddressStatusByAddressId(Integer addressId, String addressStatus) {
        String sql="update address set address_status=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(addressStatus);
        params.add(addressId);
        return update(sql,params);
    }
}
