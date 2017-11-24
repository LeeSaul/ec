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
            if (!orderItemInfo.getShelfStatus().equals("���ϼ�")){
                //�����е���Ʒ�Ѿ��¼�
                request.setAttribute("info","����������Ʒ�Ѿ��¼�");
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                return;
            }
            if (orderItemInfo.getProductCount()>orderItemInfo.getStockNumber()){
                request.setAttribute("info","����������Ʒ��治�㣬�޷�����");
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
                request.setAttribute("info","֧��ʧ�ܣ��˻����㣬���ȳ�ֵ");
                request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
            }else {
                request.setAttribute("info","֧���ɹ�");
                //֧���ɹ�Ҫ�۳��û��Ľ����ӹ���Ա�Ľ����Ķ���״̬Ϊ�Ѹ���
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
                            //���¿����Ϣ
                            for (OrderItemInfo orderItemInfo : infoByOrderListId) {
                                boolean b3 = stockService.deleteStock(orderItemInfo.getProductId(), -orderItemInfo.getProductCount());
                            }
                            request.setAttribute("info","֧���ɹ�");
                            request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
                        }
                    }
                }
            }
        }else {
            request.setAttribute("info","�������");
            request.getRequestDispatcher("page/customer/pay").forward(request,response);
        }
    }
}
