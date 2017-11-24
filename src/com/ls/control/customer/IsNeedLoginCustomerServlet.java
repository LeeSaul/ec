package com.ls.control.customer;

import com.ls.entity.Customer;
import com.ls.service.CustomerService;
import com.ls.service.impl.CustomerServiceImpl;
import com.ls.util.PasswordMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by LS on 2017/9/14 15:44.
 * To Be or Not to Be
 */
@WebServlet("/isNeed_login_Customer.do")
public class IsNeedLoginCustomerServlet extends HttpServlet {
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
        String customerName=null;
        String customerPassword=null;

        //判断session中是否存在信息
        HttpSession session = request.getSession();
        if (session!=null){
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer!=null){
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                return;
            }
        }
        //判断cookie是否存在信息
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().trim().equals("customerName")){
                    customerName =  URLDecoder.decode(cookie.getValue().trim(), "utf-8");
//                    customerName=cookie.getValue().trim();
                }
                if (cookie.getName().trim().equals("customerPassword")){
                    customerPassword=cookie.getValue().trim();
                }
            }
        }
        if (customerName!=null&&customerPassword!=null){
            Customer customerLogin = customerService.customerLogin(customerName, customerPassword);
            if (customerLogin!=null){
                session.setAttribute("customer",customerLogin);
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                return;
            }
        }
        response.sendRedirect("page/customer/customerLogin.jsp");
    }
}
