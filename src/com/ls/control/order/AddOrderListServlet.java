package com.ls.control.order;

import com.ls.entity.Customer;
import com.ls.entity.Shopcart;
import com.ls.entity.ShopcartInfo;
import com.ls.service.OrderItemService;
import com.ls.service.OrderListService;
import com.ls.service.ShopCartService;
import com.ls.service.impl.OrderItemServiceImpl;
import com.ls.service.impl.OrderListServiceImpl;
import com.ls.service.impl.ShopCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/9/18 18:52.
 * To Be or Not to Be
 */
@WebServlet(name = "AddOrderListServlet",urlPatterns = "/add.orderList.do")
public class AddOrderListServlet extends HttpServlet {
    private OrderListService orderListService;
    private OrderItemService orderItemService;
    private ShopCartService shopCartService;
    @Override
    public void init() throws ServletException {
        super.init();
        orderListService=new OrderListServiceImpl();
        orderItemService=new OrderItemServiceImpl();
        shopCartService=new ShopCartServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //提交订单，跳到本servlet，添加一条订单记录，子订单记录，删除购物车所有的记录，然后跳到输入密码页面

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String addressId = request.getParameter("addressId");
        String totalMoney = request.getParameter("totalMoney");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Integer addOrderListBackId = orderListService.addOrderListBackId(customer.getId(), Integer.parseInt(addressId), new BigDecimal(totalMoney));
        if (addOrderListBackId>0){
            List<ShopcartInfo> shopcartInfos = (List<ShopcartInfo>) session.getAttribute("shopcartInfos");
            if (shopcartInfos!=null){
                for (ShopcartInfo shopcartInfo : shopcartInfos) {
                    Integer addOrderItem = orderItemService.addOrderItem(addOrderListBackId, shopcartInfo.getpId(), shopcartInfo.getProductCartCount());
                }
                //清空购物车
                boolean b = shopCartService.deleteShopcartByCustomerId(customer.getId());
                if (b){
                    System.out.println("清空购物车成功");
                }
                request.setAttribute("orderListId",addOrderListBackId);
                request.setAttribute("totalMoney",totalMoney);
                request.getRequestDispatcher("page/customer/pay.jsp").forward(request,response);
            }
        }
    }
}
