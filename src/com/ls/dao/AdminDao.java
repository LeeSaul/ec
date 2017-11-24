package com.ls.dao;

import com.ls.entity.Admin;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/11 19:16.
 * To Be or Not to Be
 */
public interface AdminDao {
    //管理员登录
    Admin findAdmin(Admin admin);
    //管理员登录时间修改
    boolean updateAdminLoginTime(Integer id);
    //增加金额
    boolean updateAdminMoeny(String name, BigDecimal money);
    //查找主账户信息
    Admin findMasterAccount(String name);
}
