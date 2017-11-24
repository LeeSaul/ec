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
 * Created by LS on 2017/9/24 20:40.
 * To Be or Not to Be
 */
@WebServlet(name = "UpdateShopcartServlet",urlPatterns = "/update_shopcart.do")
public class UpdateShopcartServlet extends HttpServlet {
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
        String oper = request.getParameter("oper");
        Integer count=new Integer(request.getParameter("count"));
        Integer shopcartId=new Integer(request.getParameter("shopcartId"));
        if (oper.equals("add")){
            count++;

        }else if (oper.equals("decrease")){
            count--;
        }
        boolean b = shopCartService.updateShopcartAddAndDecrease(count, shopcartId);
        if (b){
            request.getRequestDispatcher("shopcart_info.view").forward(request,response);
        }

    }
}
