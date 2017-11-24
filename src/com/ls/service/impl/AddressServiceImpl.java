package com.ls.service.impl;

import com.ls.dao.AddressDao;
import com.ls.dao.impl.AddressDaoImpl;
import com.ls.entity.Address;
import com.ls.service.AddressService;

import java.util.List;

/**
 * Created by LS on 2017/9/18 14:40.
 * To Be or Not to Be
 */
public class AddressServiceImpl implements AddressService{
    private AddressDao addressDao;

    public AddressServiceImpl() {
        addressDao=new AddressDaoImpl();
    }

    @Override
    public Integer addAddressBackId(Integer customerId,String province,String city,String county,String road,String addressPhone,String addressReceiver) {
        Address address=new Address();
        address.setCustomerId(customerId);
        address.setProvince(province);
        address.setCity(city);
        address.setCounty(county);
        address.setRoad(road);
        address.setAddressPhone(addressPhone);
        address.setAddressReceiver(addressReceiver);
        List<Address> addressByCustomerId = findAddressByCustomerId(customerId);
        if (addressByCustomerId!=null){
            address.setAddressStatus(Address.ADDRESS_OTHER);
        }else {
            address.setAddressStatus(Address.ADDRESS_DEFAULT);
        }
        return addressDao.addAddressBackId(address);
    }

    @Override
    public List<Address> findAddressByCustomerId(Integer customerId){
        return addressDao.findAddressByCustomerId(customerId);
    }

    @Override
    public Address findAddressByAddressId(Integer addressId) {
        return addressDao.findAddressByAddressId(addressId);
    }

    @Override
    public boolean updateAddressStatusByAddressId(Integer addressId, String addressStatus) {
        return addressDao.updateAddressStatusByAddressId(addressId,addressStatus);
    }
}
