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
import java.util.List;

/**
 * Created by LS on 2017/9/13 18:30.
 * To Be or Not to Be
 */
@WebServlet("/show_stockInfo.view")
public class ShowStocksServlet extends HttpServlet {
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

        List<StockInfo> stockInfos = stockInfoService.ListStockInfos();
        if (stockInfos!=null){
            request.setAttribute("stockInfos",stockInfos);
            request.getRequestDispatcher("page/stock/showStocks.jsp").forward(request,response);
        }else {
            request.setAttribute("info","暂无商品信息，请先添加商品信息");
            request.getRequestDispatcher("page/stock/showStocks.jsp").forward(request,response);
        }
    }
}
