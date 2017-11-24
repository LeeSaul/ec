package com.ls.service;

import com.ls.entity.Address;

import java.util.List;

/**
 * Created by LS on 2017/9/18 14:39.
 * To Be or Not to Be
 */
public interface AddressService {
    //��ӵ�ַ��Ϣ
    Integer addAddressBackId(Integer customerId,String province,String city,String county,String road,String addressPhone,String addressReceiver);
    //ͨ���û�id�����Ƿ�����ջ���Ϣ
    List<Address> findAddressByCustomerId(Integer customerId);
    //ͨ����ַid���Ҷ�Ӧ�ĵ�ַ��Ϣ
    Address findAddressByAddressId(Integer addressId);
    //ͨ����ַid���Ķ�Ӧ�ĵ�ַ״̬��Ĭ�ϵ�ַ��������ַ��
    boolean updateAddressStatusByAddressId(Integer addressId,String addressStatus);
}
