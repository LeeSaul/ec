package com.ls.control.customer;

import com.ls.entity.Customer;
import com.ls.entity.OrderListInfo;
import com.ls.service.OrderListInfoService;
import com.ls.service.impl.OrderListInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/20 8:14.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowOrdersServlet",urlPatterns = "/customer_orders.view")
public class ShowOrdersServlet extends HttpServlet {
    private OrderListInfoService orderListInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderListInfoService=new OrderListInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Integer customerId=customer.getId();
        List<OrderListInfo> orderListInfos = orderListInfoService.ListOrders(customerId);
        request.setAttribute("orders",orderListInfos);
        request.setAttribute("info","当前没有任何订单哦");
        request.getRequestDispatcher("page/customer/showCustomerOrders.jsp").forward(request,response);
    }
}
