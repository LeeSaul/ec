package com.ls.control.order;

import com.ls.entity.Address;
import com.ls.entity.Customer;
import com.ls.service.AddressService;
import com.ls.service.OrderListService;
import com.ls.service.impl.AddressServiceImpl;
import com.ls.service.impl.OrderListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/18 16:49.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowOrderListServlet",urlPatterns = "/order_list.view")
public class ShowOrderListServlet extends HttpServlet {
    private AddressService addressService;
    private OrderListService orderListService;
    @Override
    public void init() throws ServletException {
        super.init();
        addressService=new AddressServiceImpl();
        orderListService=new OrderListServiceImpl();
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
        List<Address> addresses = addressService.findAddressByCustomerId(customer.getId());
        if (addresses==null){
            request.setAttribute("info","暂无收货人信息");
        }else {
            session.setAttribute("addresses",addresses);
        }
        request.getRequestDispatcher("page/orderlist/showOrderList.jsp").forward(request,response);
    }
}
