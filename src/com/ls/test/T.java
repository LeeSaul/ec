package com.ls.test;


import com.ls.entity.Admin;
import com.ls.entity.StockInfo;
import com.ls.service.AdminService;
import com.ls.service.StockInfoService;
import com.ls.service.impl.AdminServiceImpl;
import com.ls.service.impl.StockInfoServiceImpl;

/**
 * Created by LS on 2017/9/13 15:26.
 * To Be or Not to Be
 */
public class T {
    public static void main(String[] args) {
        AdminService adminService=new AdminServiceImpl();
        Admin admin = adminService.adminLogin("xiaohuang", "'bb' or 1=1");
        System.out.println("========"+admin);
    }
}
