package com.ls.dao;

import com.ls.entity.Admin;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/11 19:16.
 * To Be or Not to Be
 */
public interface AdminDao {
    //����Ա��¼
    Admin findAdmin(Admin admin);
    //����Ա��¼ʱ���޸�
    boolean updateAdminLoginTime(Integer id);
    //���ӽ��
    boolean updateAdminMoeny(String name, BigDecimal money);
    //�������˻���Ϣ
    Admin findMasterAccount(String name);
}
