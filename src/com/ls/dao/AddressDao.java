package com.ls.dao;

import com.ls.entity.Address;

import java.util.List;

/**
 * Created by LS on 2017/9/18 14:31.
 * To Be or Not to Be
 */
public interface AddressDao {
    //��ӵ�ַ��Ϣ
    Integer addAddressBackId(Address address);
    //ͨ���û�id�����Ƿ�����ջ���Ϣ
    List<Address> findAddressByCustomerId(Integer customerId);
    //ͨ����ַid���Ҷ�Ӧ�ĵ�ַ��Ϣ
    Address findAddressByAddressId(Integer addressId);
    //ͨ����ַid���Ķ�Ӧ�ĵ�ַ״̬��Ĭ�ϵ�ַ��������ַ��
    boolean updateAddressStatusByAddressId(Integer addressId,String addressStatus);
}
