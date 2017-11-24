package com.ls.service;

import com.ls.entity.Admin;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/11 19:23.
 * To Be or Not to Be
 */
public interface AdminService {
    //管理员登录
    Admin adminLogin(String adminName, String adminPassword);
    //增加金额
    boolean updateAdminMoeny(String name, BigDecimal money);
    //查找主账户信息
    Admin findMasterAccount(String name);
}
