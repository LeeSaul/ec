package com.ls.control.stock;

import com.ls.entity.StockInfo;
import com.ls.service.StockInfoService;
import com.ls.service.impl.StockInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LS on 2017/9/13 23:08.
 * To Be or Not to Be
 */
@WebServlet("/add_stock.view")
public class AddStockViewServlet extends HttpServlet {

    private StockInfoService stockInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        stockInfoService=new StockInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Integer productId = Integer.parseInt(request.getParameter("productId"));
        StockInfo infoByProductId = stockInfoService.findStockInfoByProductId(productId);
        request.setAttribute("stockInfo",infoByProductId);
        request.getRequestDispatcher("page/stock/addStock.jsp").forward(request,response);
    }
}
