package com.ls.control.shopcart;

import com.ls.entity.Customer;
import com.ls.service.ShopCartService;
import com.ls.service.impl.ShopCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LS on 2017/9/22 10:47.
 * To Be or Not to Be
 */
@WebServlet(name = "DeleteShopcartServlet",urlPatterns = "/delete_shopcart.do")
public class DeleteShopcartServlet extends HttpServlet {
    private ShopCartService shopCartService;
    @Override
    public void init() throws ServletException {
        super.init();
        shopCartService=new ShopCartServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String shopcartId = request.getParameter("shopcartId");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Integer customerId=customer.getId();
        if (shopcartId!=null){
            Integer shId=Integer.parseInt(shopcartId);
            boolean b = shopCartService.deleteShopcartByShopcartId(shId);
            request.setAttribute("info","删除成功");
            request.getRequestDispatcher("shopcart_info.view").forward(request,response);
        }else {
            boolean b = shopCartService.deleteShopcartByCustomerId(customerId);
            request.setAttribute("info","清空成功");
            request.getRequestDispatcher("shopcart_info.view").forward(request,response);
        }



    }
}
