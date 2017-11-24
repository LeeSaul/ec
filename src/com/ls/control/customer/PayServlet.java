package com.ls.control.customer;

import com.ls.entity.*;
import com.ls.service.*;
import com.ls.service.impl.*;
import com.ls.util.PasswordMd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.management.MonitorInfo;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/9/19 18:50.
 * To Be or Not to Be
 */
@WebServlet(name = "PayServlet",urlPatterns = "/pay.do")
public class PayServlet extends HttpServlet {
    private CustomerService customerService;
    private AdminService adminService;
    private OrderListService orderListService;
    private OrderItemInfoService orderItemInfoService;
    private StockService stockService;
    @Override
    public void init() throws ServletException {
        super.init();
        customerService=new CustomerServiceImpl();
        adminService=new AdminServiceImpl();
        orderListService=new OrderListServiceImpl();
        orderItemInfoService=new OrderItemInfoServiceImpl();
        stockService=new StockServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Integer orderListId = new Integer(request.getParameter("orderListId"));
        List<OrderItemInfo> infoByOrderListId = orderItemInfoService.findOrderItemInfoByOrderListId(orderListId);
        for (OrderItemInfo orderItemInfo : infoByOrderListId) {
            if (!orderItemInfo.getShelfStatus().equals("已上架")){
                //存在有的商品已经下架
                request.setAttribute("info","订单内有商品已经下架");
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                return;
            }
            if (orderItemInfo.getProductCount()>orderItemInfo.getStockNumber()){
                request.setAttribute("info","订单内有商品库存不足，无法交易");
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                return;
            }
        }
        String totalMoney1 = request.getParameter("totalMoney");
        BigDecimal totalMoney = new BigDecimal(totalMoney1);
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Admin admin = adminService.findMasterAccount("admin");
        Customer customerByName = customerService.findCustomerByName(customer.getCustomerName());
        if (PasswordMd5.generatePasswordMd5(password).equals(customerByName.getCustomerPassword())){
            if (totalMoney.compareTo(customerByName.getCustomerMoney())==1){
                request.setAttribute("info","支付失败，账户金额不足，请先充值");
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
            }else {
                request.setAttribute("info","支付成功");
                //支付成功要扣除用户的金额，增加管理员的金额，更改订单状态为已付款
                BigDecimal customerMoney=customerByName.getCustomerMoney().subtract(totalMoney);
                boolean b = customerService.updateMoneyById(customer.getId(), customerMoney);
                if (b){
                    BigDecimal adminMoney=admin.getAdminMoney().add(totalMoney);
                    boolean b1 = adminService.updateAdminMoeny("admin", adminMoney);
                    if (b1){
                        boolean b2 = orderListService.updateOrderListStatus(OrderList.NOT_SEND,orderListId);
                        if (b2){
                            Customer customerById = customerService.findCustomerById(customer.getId());
                            session.setAttribute("customer",customerById);
                            //更新库存信息
                            for (OrderItemInfo orderItemInfo : infoByOrderListId) {
                                boolean b3 = stockService.deleteStock(orderItemInfo.getProductId(), -orderItemInfo.getProductCount());
                            }
                            request.setAttribute("info","支付成功");
                            request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                        }
                    }
                }
            }
        }else {
            request.setAttribute("info","密码错误");
            request.getRequestDispatcher("page/customer/pay").forward(request,response);
        }
    }
}
