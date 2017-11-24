package com.ls.dao;

import com.ls.entity.Address;

import java.util.List;

/**
 * Created by LS on 2017/9/18 14:31.
 * To Be or Not to Be
 */
public interface AddressDao {
    //添加地址信息
    Integer addAddressBackId(Address address);
    //通过用户id查找是否存在收货信息
    List<Address> findAddressByCustomerId(Integer customerId);
    //通过地址id查找对应的地址信息
    Address findAddressByAddressId(Integer addressId);
    //通过地址id更改对应的地址状态（默认地址，其他地址）
    boolean updateAddressStatusByAddressId(Integer addressId,String addressStatus);
}
