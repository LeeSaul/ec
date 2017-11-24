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
 * Created by LS on 2017/9/21 18:44.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowCustomerOrdersByStatusServlet",urlPatterns = "/customer_orders_status.view")
public class ShowCustomerOrdersByStatusServlet extends HttpServlet {
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
        String status = request.getParameter("status");
        List<OrderListInfo> ordersByStatus = orderListInfoService.ListCustomerOrdersByStatus(status, customer.getId());
        String info=null;
        if (ordersByStatus!=null){
            request.setAttribute("orders",ordersByStatus);
        }else if(status.equals("NOT_PAY")){
            info="没有待付款的订单哦";
        }else if (status.equals("NOT_SEND")){
            info="没有待发货的订单哦";
        }else if (status.equals("NOT_CONFIRMED")){
            info="没有待确认的订单哦";
        }else if (status.equals("CONFIRMED")){
            info="没有已完成的订单哦";
        }else {
            info="出错啦";
        }
        request.setAttribute("info",info);
        request.getRequestDispatcher("page/customer/showCustomerOrders.jsp").forward(request,response);
    }
}
