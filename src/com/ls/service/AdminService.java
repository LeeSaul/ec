package com.ls.service;

import com.ls.entity.Admin;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/11 19:23.
 * To Be or Not to Be
 */
public interface AdminService {
    //����Ա��¼
    Admin adminLogin(String adminName, String adminPassword);
    //���ӽ��
    boolean updateAdminMoeny(String name, BigDecimal money);
    //�������˻���Ϣ
    Admin findMasterAccount(String name);
}
