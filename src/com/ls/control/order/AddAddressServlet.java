package com.ls.control.order;

import com.ls.entity.Address;
import com.ls.entity.Customer;
import com.ls.service.AddressService;
import com.ls.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/18 14:58.
 * To Be or Not to Be
 */
@WebServlet(name = "AddAddressServlet",urlPatterns = "/add_address.do")
public class AddAddressServlet extends HttpServlet {
    private AddressService addressService;

    @Override
    public void init() throws ServletException {
        super.init();
        addressService=new AddressServiceImpl();
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
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String county = request.getParameter("county");
        String road = request.getParameter("road");
        String addressPhone = request.getParameter("addressPhone");
        String addressReceiver = request.getParameter("addressReceiver");
        Integer addAddressBackId = addressService.addAddressBackId(customerId, province, city, county, road,addressPhone,addressReceiver);
//        Address addressByAddressId = addressService.findAddressByAddressId(addAddressBackId);
//        request.setAttribute("address",addressByAddressId);
        if (addAddressBackId>0){
            List<Address> addressByCustomerId = addressService.findAddressByCustomerId(customerId);
            if (addressByCustomerId!=null){
                session.setAttribute("addresses",addressByCustomerId);
            }
        }
        request.getRequestDispatcher("page/orderlist/showOrderList.jsp").forward(request,response);
    }
}
