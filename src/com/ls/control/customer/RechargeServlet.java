package com.ls.control.customer;

import com.ls.entity.Customer;
import com.ls.service.CustomerService;
import com.ls.service.impl.CustomerServiceImpl;
import com.ls.util.PasswordMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/20 16:20.
 * To Be or Not to Be
 */
@WebServlet(name = "RechargeServlet",urlPatterns = "/recharge.do")
public class RechargeServlet extends HttpServlet {
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

        String money = request.getParameter("money");
        BigDecimal rechargeMoney=new BigDecimal(money);
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer.getCustomerPassword().equals(PasswordMd5.generatePasswordMd5(password))){
            BigDecimal nowMoney = customer.getCustomerMoney().add(rechargeMoney);
            boolean b = customerService.updateMoneyById(customer.getId(), nowMoney);
            if (b){
                request.setAttribute("info","≥‰÷µ≥…π¶");
            }
        }else {
            request.setAttribute("info","√‹¬Î¥ÌŒÛ");
        }
        Customer customerById = customerService.findCustomerById(customer.getId());
        session.setAttribute("customer",customerById);
        request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
    }
}
