package com.ls.control.admin;

import com.ls.entity.Admin;
import com.ls.service.AdminService;
import com.ls.service.impl.AdminServiceImpl;
import com.ls.util.PasswordMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by LS on 2017/9/11 19:08.
 * To Be or Not to Be
 */
@WebServlet("/admin.login")
public class AdminLoginServlet extends HttpServlet {
    AdminService adminService;

    @Override
    public void init() throws ServletException {
        super.init();
        adminService=new AdminServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");

        String isKeep = request.getParameter("isKeep");
        if ("on".equals(isKeep)){
            System.out.println("记住密码");
        }else {
            System.out.println("不记住密码");
        }
        Admin admin = adminService.adminLogin(adminName, adminPassword);
        if (admin!=null){
            //登录的时候保存到session和cookie
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            if ("on".equals(isKeep)){
                System.out.println("记住密码");
//                String urlName = URLEncoder.encode(adminName,"UTF-8");
                Cookie cookieAdminName = new Cookie("adminName", adminName);
                Cookie cookieAdminPassword = new Cookie("adminPassword", PasswordMd5.generatePasswordMd5(adminPassword));
                cookieAdminName.setMaxAge(7*60*60*24);
                cookieAdminPassword.setMaxAge(7*60*60*24);
                response.addCookie(cookieAdminName);
                response.addCookie(cookieAdminPassword);
            }else {
                System.out.println("不记住密码");
            }
            request.getRequestDispatcher("page/admin/adminIndex.jsp").forward(request,response);
        }else {
            request.setAttribute("info","登录失败");
            request.getRequestDispatcher("page/admin/adminLogin.jsp").forward(request,response);
        }
    }
}
