package com.ls.control.shopcart;

import com.ls.entity.Customer;
import com.ls.entity.ShopcartInfo;
import com.ls.service.ShopcartInfoService;
import com.ls.service.impl.ShopInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/9/17 13:53.
 * To Be or Not to Be
 */
@WebServlet(name = "ShowShopcartInfoServlet",urlPatterns = "/shopcart_info.view")
public class ShowShopcartInfoServlet extends HttpServlet {
    private ShopcartInfoService shopcartInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        shopcartInfoService=new ShopInfoServiceImpl();
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
        String info = request.getParameter("info");
        List<ShopcartInfo> shopcartInfos = shopcartInfoService.listShopcartInfosByCustomerId(customerId);
        session.setAttribute("shopcartInfos",shopcartInfos);
        request.setAttribute("info",info);
        if (shopcartInfos!=null){
            request.getRequestDispatcher("page/shopcart/showShopcart.jsp").forward(request,response);
        }else {
            request.setAttribute("info","购物车空空的，赶快去挑选心仪的商品吧");
            request.getRequestDispatcher("page/shopcart/showShopcart.jsp").forward(request,response);
        }
    }
}
