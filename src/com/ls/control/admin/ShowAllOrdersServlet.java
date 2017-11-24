package com.ls.control.admin;

import com.ls.entity.OrderListInfo;
import com.ls.service.OrderListInfoService;
import com.ls.service.impl.OrderListInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/20 10:25.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowAllOrdersServlet",urlPatterns = "/show_all_orders.view")
public class ShowAllOrdersServlet extends HttpServlet {
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
        List<OrderListInfo> orders = orderListInfoService.ListOrders();
        System.out.println("==============");
        System.out.println("orders"+orders);
        System.out.println("======================");
        if (orders!=null){
            request.setAttribute("orders",orders);
        }else {
            request.setAttribute("info","当前没有任何订单哦");
        }
        request.getRequestDispatcher("page/admin/showAllOrders.jsp").forward(request,response);
    }
}
