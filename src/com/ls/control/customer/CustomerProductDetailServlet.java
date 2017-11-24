package com.ls.control.customer;

import com.ls.entity.ProductDetail;
import com.ls.entity.ShelfProductInfos;
import com.ls.service.ProductDetailService;
import com.ls.service.ShelfProductInfosService;
import com.ls.service.impl.ProductDetailServiceImpl;
import com.ls.service.impl.ShelfProductInfosServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LS on 2017/9/17 11:50.
 * To Be or Not to Be
 */
@WebServlet(name = "CustomerProductDetailServlet",urlPatterns = "/customer_productDetail.view")
public class CustomerProductDetailServlet extends HttpServlet {
    ShelfProductInfosService shelfProductInfosService;

    @Override
    public void init() throws ServletException {
        super.init();
        shelfProductInfosService=new ShelfProductInfosServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        ShelfProductInfos shelfProductInfoByProductId = shelfProductInfosService.findShelfProductInfoByProductId(productId);
        HttpSession session=request.getSession();
        session.setAttribute("productInfo",shelfProductInfoByProductId);
        request.getRequestDispatcher("page/customer/customerProduct.jsp").forward(request,response);

    }
}
