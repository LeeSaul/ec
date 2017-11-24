package com.ls.dao.impl;

import com.ls.dao.AdminDao;
import com.ls.entity.Admin;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/11 19:17.
 * To Be or Not to Be
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public Admin findAdmin(Admin admin) {
        String sql="select * from admin where admin_name=? AND admin_password=? AND admin_state=?";
        List<Object> params=new ArrayList<>();
        params.add(admin.getAdminName());
        params.add(admin.getAdminPassword());
        params.add(admin.getAdminState());
        List<Admin> admins = query(sql, params, Admin.class);
        if (admins!=null){
            updateAdminLoginTime(admins.get(0).getId());
            return admins.get(0);
        }
        return null;
    }

    @Override
    public boolean updateAdminLoginTime(Integer id) {
        String sql="update admin set admin_last_time=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(new Timestamp(new Date().getTime()));
        params.add(id);
        return update(sql, params);
    }

    @Override
    public boolean updateAdminMoeny(String name, BigDecimal money) {
        String sql="update admin set admin_money=? where admin_name=?";
        List<Object> params=new ArrayList<>();
        params.add(money);
        params.add(name);
        return update(sql, params);
    }

    @Override
    public Admin findMasterAccount(String name) {
        String sql="select * from admin where admin_name=?";
        List<Object> params=new ArrayList<>();
        params.add(name);
        List<Admin> query = query(sql, params, Admin.class);
        if (query!=null){
            return query.get(0);
        }
        return null;
    }
}
