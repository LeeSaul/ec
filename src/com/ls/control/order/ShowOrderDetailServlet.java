package com.ls.control.order;

import com.ls.entity.OrderListInfo;
import com.ls.service.OrderListInfoService;
import com.ls.service.impl.OrderListInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LS on 2017/9/20 8:51.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowOrderDetailServlet",urlPatterns = "/show_order_detail.view")
public class ShowOrderDetailServlet extends HttpServlet {
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

        Integer orderItemId=new Integer(request.getParameter("orderItemId"));
        OrderListInfo orderDetail = orderListInfoService.OrderDetails(orderItemId);
        request.setAttribute("orderDetail",orderDetail);
        request.getRequestDispatcher("page/orderlist/showOrderDetail.jsp").forward(request,response);
    }
}
