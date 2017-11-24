package com.ls.control.order;

import com.ls.entity.*;
import com.ls.service.*;
import com.ls.service.impl.*;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/9/20 18:31.
 * To Be or Not to Be
 */
@WebServlet(name = "UpdateOrderStatusServlet",urlPatterns = "/update_status.do")
public class UpdateOrderStatusServlet extends HttpServlet {
    OrderItemService orderItemService;
    OrderListService orderListService;
    OrderItemInfoService orderItemInfoService;
    ProductService productService;
    OutStockInfoService outStockInfoService;
    @Override
    public void init() throws ServletException {
        super.init();
        orderItemService=new OrderItemServiceImpl();
        orderListService=new OrderListServiceImpl();
        orderItemInfoService=new OrderItemInfoServiceImpl();
        productService=new ProductServiceImpl();
        outStockInfoService=new OutStockInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        Integer orderListId=Integer.parseInt(request.getParameter("orderListId"));
        String status = request.getParameter("status");
        String updateStatus=null;
        String info=null;
        if (status.toUpperCase().equals("NOT_SEND")){
            boolean b = orderItemService.udpdateOrderItemStatus(OrderItem.ITEM_SHIPPED, orderListId);
            updateStatus= OrderList.NOT_CONFIRMED;
            boolean b1 = orderListService.updateOrderListStatus(updateStatus, orderListId);
            if (b1&&b){
                info="发货成功";
                //发货成功要添加出库表
                List<OrderItemInfo> orderItemInfoByOrderListId = orderItemInfoService.findOrderItemInfoByOrderListId(orderListId);
                Timestamp timestamp=new Timestamp(new Date().getTime());
                for (OrderItemInfo itemInfo : orderItemInfoByOrderListId) {
                    Product productById = productService.findProductById(itemInfo.getProductId());
                    OutStock outStock=new OutStock();
                    outStock.setAdminId(admin.getId());
                    outStock.setProductId(itemInfo.getProductId());
                    outStock.setOutStockNumber(itemInfo.getProductCount());
                    outStock.setOut_Time(timestamp);
                    outStock.setOutUnitPrice(productById.getProductPrice());
                    boolean b2 = outStockInfoService.addOutStockInfo(outStock);
                }
            }
        }else if (status.toUpperCase().equals("NOT_CONFIRMED")){
            updateStatus= OrderList.CONFIRMED;
            boolean b1 = orderListService.updateOrderListStatus(updateStatus, orderListId);
            if (b1){
                info="确认收货成功";
            }
        }else if (status.toUpperCase().equals("NOT_PAY")){
            String oper = request.getParameter("oper");
            //取消订单或者付款
            if (oper.equals("cancle")){
                boolean b = orderItemService.deleteOrderItem(orderListId);
                boolean b1 = orderListService.deleteOrderList(orderListId);
                if (b||b1){
                    info="取消成功";
                }
            }else if (oper.equals("pay")){
                String totalMoney = request.getParameter("totalMoney");
                request.setAttribute("totalMoney",totalMoney);
                request.setAttribute("orderListId",orderListId);
                request.getRequestDispatcher("page/customer/pay.jsp").forward(request,response);
                return;
            }
        }
        request.setAttribute("info",info);
        request.getRequestDispatcher("/customer_orders.view").forward(request,response);
    }
}
