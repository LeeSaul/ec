package com.ls.control.shopcart;

import com.ls.entity.Customer;
import com.ls.entity.Shelf;
import com.ls.entity.Shopcart;
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
 * Created by LS on 2017/9/17 12:44.
 * To Be or Not to Be
 */
@WebServlet(name = "AddShopcartServlet",urlPatterns = "/add_shopcart.do")
public class AddShopcartServlet extends HttpServlet {
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

        String productId = request.getParameter("productId");
        String productCartCount=request.getParameter("productCartCount");
        HttpSession session=request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Integer customerId=customer.getId();
        String productName = request.getParameter("productName");
        String productPrice=request.getParameter("productPrice");
        //�жϹ��ﳵ�Ƿ��Ѵ��ڸ���Ʒ��������ھ��Ǹ��ģ������ھ������
        Shopcart shopcartByIds = shopCartService.findShopcartByCustomerIdAndProductId(customerId, new Integer(productId));
        int i=0;
        boolean b=false;
        if (shopcartByIds!=null){
            b = shopCartService.updateShopcartById(new Integer(productCartCount), shopcartByIds.getId());
        }else {
            i = shopCartService.addProductToCartBackId(customerId, new Integer(productId), new Integer(productCartCount));
        }
        if (i>0||b){
            request.setAttribute("productName","��Ʒ����"+productName);
            request.setAttribute("productPrice","�۸񣺣�"+productPrice);
            request.setAttribute("productCartCount","������"+productCartCount);
            request.setAttribute("info","�ѳɹ���ӵ����ﳵ");
        }else {
            request.setAttribute("info","��Ʒ���ʧ��");
        }
        request.getRequestDispatcher("page/customer/customerIndex.jsp").forward(request,response);
    }
}
