package com.ls.control.customer;

import com.ls.entity.Customer;
import com.ls.service.CustomerService;
import com.ls.service.impl.CustomerServiceImpl;
import com.ls.util.PasswordMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by LS on 2017/9/13 15:51.
 * To Be or Not to Be
 */
@WebServlet("/customer_login.do")
public class CustomerLoginServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService=new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取顾客账户名和密码
        String customerName = request.getParameter("customerName");
        String customerPassword = request.getParameter("customerPassword");
        String isKeep = request.getParameter("isKeep");
        System.out.println("是否記住"+isKeep);
        if (customerName==null){
            System.out.println("hello,woshikong");
        }
        Customer customer = customerService.customerLogin(customerName, PasswordMd5.generatePasswordMd5(customerPassword));
        if (customer!=null){
            HttpSession session = request.getSession();
            session.setAttribute("customer",customer);
            if ("on".equals(isKeep)){
                System.out.println("记住密码");
                //登录的时候保存到session和cookie
                String urlName = URLEncoder.encode(customerName,"UTF-8");
                Cookie cookieCustomerName = new Cookie("customerName", urlName);
                Cookie cookieCustomerPassword = new Cookie("customerPassword", PasswordMd5.generatePasswordMd5(customerPassword));
                cookieCustomerName.setMaxAge(7*60*60*24);
                cookieCustomerPassword.setMaxAge(7*60*60*24);
                response.addCookie(cookieCustomerName);
                response.addCookie(cookieCustomerPassword);
            }else {
                System.out.println("不记住密码");
            }
            request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
        }else {
            request.setAttribute("info","账户名或密码错误");
            request.getRequestDispatcher("page/customer/customerLogin.jsp").forward(request,response);
        }
    }
}
