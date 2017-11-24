package com.ls.service.impl;

import com.ls.dao.AdminDao;
import com.ls.dao.impl.AdminDaoImpl;
import com.ls.entity.Admin;
import com.ls.service.AdminService;

import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/11 19:23.
 * To Be or Not to Be
 */
public class AdminServiceImpl implements AdminService{
    private AdminDao adminDao;

    public AdminServiceImpl() {
        adminDao = new AdminDaoImpl();
    }

    @Override
    public Admin adminLogin(String adminName, String adminPassword) {
        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        admin.setAdminState(Admin.ADMIN_STATE_NORMAL);
        System.out.println(admin);
        return adminDao.findAdmin(admin);
    }

    @Override
    public boolean updateAdminMoeny(String name, BigDecimal money) {
        return adminDao.updateAdminMoeny(name,money);
    }

    @Override
    public Admin findMasterAccount(String name) {
        return adminDao.findMasterAccount(name);
    }
}
