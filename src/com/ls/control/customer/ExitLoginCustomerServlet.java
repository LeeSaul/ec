package com.ls.control.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by LS on 2017/9/14 16:12.
 * To Be or Not to Be
 */
@WebServlet("/exit_customer.do")
public class ExitLoginCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        Cookie customerName=null;
        Cookie customerPassword=null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().trim().equals("customerName")){
                    customerName=cookie;
                    customerName.setMaxAge(0);
                }
                if (cookie.getName().trim().equals("customerPassword")){
                    customerPassword=cookie;
                    customerPassword.setMaxAge(0);
                    System.out.println("1111111111111111111111111111");
                }
            }
            if (customerName!=null&&customerPassword!=null){
                response.addCookie(customerName);
                response.addCookie(customerPassword);
            }
        }
        response.sendRedirect("welcome.jsp");
    }
}
