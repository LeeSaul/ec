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
 * Created by LS on 2017/9/13 16:20.
 * To Be or Not to Be
 */
@WebServlet("/customer_register.do")
public class CustomerRegisterServlet extends HttpServlet {
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

        String cName = request.getParameter("customerName");
        String cPassword = request.getParameter("customerPassword");
        String cPassword2 = request.getParameter("customerPassword2");
        if (!cPassword.equals(cPassword2)){
            //两次密码判定是否一致，前台js判断或者这里面判断，然后返还错误信息
            System.out.println("两次密码不一样");
            request.setAttribute("info","两次密码不一致");
            request.getRequestDispatcher("page/customer/customerRegister.jsp").forward(request,response);
            return;
        }
        Customer customerByName = customerService.findCustomerByName(cName);
        if (customerByName!=null){
            request.setAttribute("info","用户名已存在，请重新输入");
            request.getRequestDispatcher("page/customer/customerRegister.jsp").forward(request,response);
            return;
        }
        System.out.println("用戶名"+cName);
        int backId = customerService.customerRegisterBackId(cName, PasswordMd5.generatePasswordMd5(cPassword));
        Customer customerById;
        if (backId>0){
            customerById = customerService.findCustomerById(backId);
            if (customerById!=null){
                /*HttpSession session = request.getSession();
                session.setAttribute("customer",customerById);
                String urlName = URLEncoder.encode(cName,"UTF-8");
                System.out.println("urlName"+urlName);
                Cookie customerName = new Cookie("customerName", urlName);
                Cookie customerPassword = new Cookie("customerPassword", cPassword);
                customerName.setMaxAge(60*60*24);//一天
                customerPassword.setMaxAge(60*60*24);
                response.addCookie(customerName);
                response.addCookie(customerPassword);*/
                request.setAttribute("info","注册成功");
                request.getRequestDispatcher("page/customer/customerLogin.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("info","注册失败");
            request.getRequestDispatcher("page/customer/customerRegister.jsp").forward(request,response);
        }
    }
}
