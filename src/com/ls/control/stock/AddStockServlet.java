package com.ls.control.stock;

import com.ls.entity.Admin;
import com.ls.service.StockService;
import com.ls.service.impl.StockServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by LS on 2017/9/13 20:11.
 * To Be or Not to Be
 */
@WebServlet("/add_stock.do")
public class AddStockServlet extends HttpServlet {
    private StockService stockService;

    @Override
    public void init() throws ServletException {
        super.init();
        stockService=new StockServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BigDecimal productPrice=new BigDecimal(request.getParameter("productPrice"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer stockId = null;
        try {
            stockId = Integer.parseInt(request.getParameter("stockId"));
        } catch (NumberFormatException e) {
        }
        Integer stockNumber=Integer.parseInt(request.getParameter("stockNumber"));
        HttpSession session=request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin==null){
            response.sendRedirect("page/admin/adminLogin.jsp");
        }else {
            Integer adminId=admin.getId();
            boolean b = stockService.addStock(stockId, productId, adminId, stockNumber,productPrice);
            if (b){
                request.setAttribute("info","增加成功");
            }else {
                request.setAttribute("info","增加失败");
            }
            request.getRequestDispatcher("/show_stockInfo.view").forward(request,response);
        }
    }
}
